package com.sapient.web.application.serviceimpl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sapient.web.application.model.BrowserDeviceOSInfoResponse;
import com.sapient.web.application.model.UserAgentRequest;
import com.sapient.web.application.service.BrowserInfoDetailsService;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

import net.sf.uadetector.ReadableDeviceCategory;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.VersionNumber;
import net.sf.uadetector.service.UADetectorServiceFactory;


@Service
public class BrowserInfoDetailsServiceImpl implements BrowserInfoDetailsService {
	private static final String DEVICE_TYPE_UNKNOWN = "UNKNOWN";
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BrowserInfoDetailsServiceImpl.class);

	public static final UserAgentStringParser PARSER = UADetectorServiceFactory.getResourceModuleParser();

	@Override
	public BrowserDeviceOSInfoResponse getBrowserInfoDetails(UserAgentRequest userAgentRequest) {
		return getUserAgentDetails(userAgentRequest);
	}

	@SuppressWarnings("deprecation")
	public BrowserDeviceOSInfoResponse getUserAgentDetails(UserAgentRequest userAgentRequest) {
		UserAgent userAgentData = UserAgent.parseUserAgentString(userAgentRequest.getUserAgent());
		// browser
		Browser browser = userAgentData.getBrowser();
		LOGGER.info("Browser type: " + browser.getBrowserType().getName());
		LOGGER.info("Browser name: " + browser.getName());
		LOGGER.info("Browser render engine: " + browser.getRenderingEngine());

		Version version = userAgentData.getBrowserVersion();
		if (version != null) {
			LOGGER.info("Browser version: " + version.getVersion());
			LOGGER.info("Browser major version: " + version.getMajorVersion());
			LOGGER.info("Browser minor version: " + version.getMinorVersion());
		}
		System.out.println("Browser manufacturer: " + browser.getManufacturer().getName());

		// operating system
		OperatingSystem os = userAgentData.getOperatingSystem();
		LOGGER.info("\nOS Name: " + os.getName());
		LOGGER.info("OS Manufacturer: " + os.getManufacturer());
		OperatingSystem group = os.getGroup();
		LOGGER.info("OS group: " + group.getName());

		// device type
		DeviceType deviceType = os.getDeviceType();
		LOGGER.info("\nDevice: " + deviceType.getName());

		BrowserDeviceOSInfoResponse browserInfoData = new BrowserDeviceOSInfoResponse();
		browserInfoData.setOs(group.getName());
		browserInfoData.setOsVersion(os.getName());
		browserInfoData.setBrowser(browser.getName());
		browserInfoData.setBrowserVersion(version.getVersion());
		browserInfoData.setDevice(deviceType.getName());
		if (os.isMobileDevice()) {
			browserInfoData.setDeviceType("Mobile");
		} else if (!os.isMobileDevice()) {
			browserInfoData.setDeviceType("Desktop");
		} else {
			browserInfoData.setDeviceType(DEVICE_TYPE_UNKNOWN);
		}
		return browserInfoData;
	}

	@Override
	public BrowserDeviceOSInfoResponse getBrowserInfoDetailsV2(UserAgentRequest userAgentRequest) {
		return getUserAgentDetailsV2(userAgentRequest);
	}

	public BrowserDeviceOSInfoResponse getUserAgentDetailsV2(UserAgentRequest userAgentRequest) {
		ReadableUserAgent readableUserAgent = PARSER.parse(userAgentRequest.getUserAgent());
		// type
		LOGGER.info("Browser type: " + readableUserAgent.getType().getName());
		LOGGER.info("Browser name: " + readableUserAgent.getName());
		VersionNumber browserVersion = readableUserAgent.getVersionNumber();
		LOGGER.info("Browser version: " + browserVersion.toVersionString());
		LOGGER.info("Browser version major: " + browserVersion.getMajor());
		LOGGER.info("Browser version minor: " + browserVersion.getMinor());
		LOGGER.info("Browser version bug fix: " + browserVersion.getBugfix());
		LOGGER.info("Browser version extension: " + browserVersion.getExtension());
		LOGGER.info("Browser producer: " + readableUserAgent.getProducer());

		// operating system
		net.sf.uadetector.OperatingSystem os = readableUserAgent.getOperatingSystem();
		LOGGER.info("\nOS Name: " + os.getName());
		LOGGER.info("OS Producer: " + os.getProducer());
		VersionNumber osVersion = os.getVersionNumber();
		LOGGER.info("OS version: " + osVersion.toVersionString());
		LOGGER.info("OS version major: " + osVersion.getMajor());
		LOGGER.info("OS version minor: " + osVersion.getMinor());
		LOGGER.info("OS version bug fix: " + osVersion.getBugfix());
		LOGGER.info("OS version extension: " + osVersion.getExtension());

		// device category
		ReadableDeviceCategory device = readableUserAgent.getDeviceCategory();
		LOGGER.info("\nDevice: " + device.getName());
		LOGGER.info("\nDevice Category : " +device.getCategory());
		
		BrowserDeviceOSInfoResponse browserInfoDetails = new BrowserDeviceOSInfoResponse();
		browserInfoDetails.setOs(os.getName());
		browserInfoDetails.setOsVersion(osVersion.toVersionString());
		browserInfoDetails.setBrowser(readableUserAgent.getName());
		browserInfoDetails.setBrowserVersion(browserVersion.toVersionString());
		browserInfoDetails.setDevice(device.getName());
		browserInfoDetails.setDeviceType(device.getCategory().toString());
		return browserInfoDetails;
	}

}