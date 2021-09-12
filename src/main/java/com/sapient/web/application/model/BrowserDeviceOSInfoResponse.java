package com.sapient.web.application.model;

public class BrowserDeviceOSInfoResponse {

	private String os;
	private String osVersion;
	private String browser;
	private String browserVersion;
	private String device;
	private String deviceType;

	public BrowserDeviceOSInfoResponse() {
		super();
	}

	public BrowserDeviceOSInfoResponse(String os, String osVersion, String browser, String browserVersion,
			String device, String deviceType) {
		super();
		this.os = os;
		this.osVersion = osVersion;
		this.browser = browser;
		this.browserVersion = browserVersion;
		this.device = device;
		this.deviceType = deviceType;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((browser == null) ? 0 : browser.hashCode());
		result = prime * result + ((browserVersion == null) ? 0 : browserVersion.hashCode());
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((osVersion == null) ? 0 : osVersion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BrowserDeviceOSInfoResponse other = (BrowserDeviceOSInfoResponse) obj;
		if (browser == null) {
			if (other.browser != null)
				return false;
		} else if (!browser.equals(other.browser))
			return false;
		if (browserVersion == null) {
			if (other.browserVersion != null)
				return false;
		} else if (!browserVersion.equals(other.browserVersion))
			return false;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (deviceType == null) {
			if (other.deviceType != null)
				return false;
		} else if (!deviceType.equals(other.deviceType))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (osVersion == null) {
			if (other.osVersion != null)
				return false;
		} else if (!osVersion.equals(other.osVersion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BrowserDeviceOSInfoResponse [os=" + os + ", osVersion=" + osVersion + ", browser=" + browser
				+ ", browserVersion=" + browserVersion + ", device=" + device + ", deviceType=" + deviceType + "]";
	}

}