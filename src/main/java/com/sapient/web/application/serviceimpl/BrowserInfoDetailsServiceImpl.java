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
import nl.basjes.parse.useragent.UserAgentAnalyzer;


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
	
public BrowserDeviceOSInfoResponse getBrowserInfoDetailsV3(UserAgentRequest userAgentRequest) {
		
		return getBrowserInfoDetailsV3Data(userAgentRequest);
	}
	
	public BrowserDeviceOSInfoResponse getBrowserInfoDetailsV3Data(UserAgentRequest userAgentRequest) {
		UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer
	                                          .newBuilder()
	                                          .hideMatcherLoadStats()
	                                          .withCache(10000)
	                                          .build();
		nl.basjes.parse.useragent.UserAgent userAgentData = userAgentAnalyzer.parse(userAgentRequest.getUserAgent());
		LOGGER.info("{}", userAgentData.toYamlTestCase(true));

        // The requested fields
		LOGGER.info ("Device Class :: "+userAgentData.getValue("DeviceClass")); // Phone
		LOGGER.info("AgentNameVersionMajor :: "+userAgentData.getValue("AgentNameVersionMajor")); // Chrome 53

        // The fields that are internally needed to build the requested fields
		LOGGER.info("AgentName :: "+userAgentData.getValue("AgentName")); // Chrome
		LOGGER.info("AgentVersion :: "+userAgentData.getValue("AgentVersion")); // 53.0.2785.124
		LOGGER.info("AgentVersionMajor :: "+userAgentData.getValue("AgentVersionMajor")); // 53

        // The rest must be the default value (i.e. no rules fired)
		LOGGER.info("DeviceName :: "+userAgentData.getValue("DeviceName")); // Nexus 6
		LOGGER.info("DeviceBrand :: "+userAgentData.getValue("DeviceBrand")); // Google
		LOGGER.info("OperatingSystemClass :: "+userAgentData.getValue("OperatingSystemClass")); // Mobile
		LOGGER.info("OperatingSystemName :: "+userAgentData.getValue("OperatingSystemName")); // Android
		LOGGER.info("OperatingSystemVersion :: "+userAgentData.getValue("OperatingSystemVersion")); // 7.0
		LOGGER.info("OperatingSystemNameVersion :: "+userAgentData.getValue("OperatingSystemNameVersion" )); // Android 7.0
		LOGGER.info("OperatingSystemVersionBuild :: "+userAgentData.getValue("OperatingSystemVersionBuild")); // NBD90Z
		LOGGER.info("LayoutEngineClass :: "+userAgentData.getValue("LayoutEngineClass")); // Browser
		LOGGER.info("LayoutEngineName :: "+userAgentData.getValue("LayoutEngineName" )); // Blink
		LOGGER.info("LayoutEngineVersion :: "+userAgentData.getValue("LayoutEngineVersion")); // 53.0
		LOGGER.info("LayoutEngineVersionMajor :: "+userAgentData.getValue("LayoutEngineVersionMajor")); // 53
		LOGGER.info("LayoutEngineNameVersion :: "+userAgentData.getValue("LayoutEngineNameVersion")); // Blink 53.0
		LOGGER.info("LayoutEngineNameVersionMajor :: "+userAgentData.getValue("LayoutEngineNameVersionMajor")); // Blink 53
		LOGGER.info("AgentClass :: "+userAgentData.getValue("AgentClass")); // Browser
		LOGGER.info("AgentNameVersion :: "+userAgentData.getValue("AgentNameVersion")); // Chrome 53.0.2785.124
		BrowserDeviceOSInfoResponse browserInfoResponse = new BrowserDeviceOSInfoResponse();
		browserInfoResponse.setOs(userAgentData.getValue("OperatingSystemName"));
		browserInfoResponse.setOsVersion(userAgentData.getValue("OperatingSystemVersion"));
		browserInfoResponse.setBrowser(userAgentData.getValue("AgentName"));
		browserInfoResponse.setBrowserVersion(userAgentData.getValue("AgentVersion"));
		browserInfoResponse .setDevice(userAgentData.getValue("DeviceClass"));
		browserInfoResponse.setDeviceType(userAgentData.getValue("DeviceName"));
		
		return  browserInfoResponse;
	}


}