package com.sapient.web.application.service;

import com.sapient.web.application.model.BrowserDeviceOSInfoResponse;
import com.sapient.web.application.model.UserAgentRequest;

public interface BrowserInfoDetailsService {

	public BrowserDeviceOSInfoResponse getBrowserInfoDetails(UserAgentRequest userAgentRequest);

	public BrowserDeviceOSInfoResponse getBrowserInfoDetailsV2(UserAgentRequest userAgentRequest);
	
	public BrowserDeviceOSInfoResponse getBrowserInfoDetailsV3(UserAgentRequest userAgentRequest);

}
