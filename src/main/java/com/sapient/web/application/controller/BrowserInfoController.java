package com.sapient.web.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.web.application.model.BrowserDeviceOSInfoResponse;
import com.sapient.web.application.model.UserAgentRequest;
import com.sapient.web.application.service.BrowserInfoDetailsService;

@RestController
@RequestMapping("/api")
public class BrowserInfoController {
	
	@Autowired
	private BrowserInfoDetailsService browserInfoDetailsService;
	
	@PostMapping("/useragent/v1/info")
	public ResponseEntity<BrowserDeviceOSInfoResponse> getBrowserInfoDetails(@RequestBody UserAgentRequest userAgentRequest){
		BrowserDeviceOSInfoResponse browserInfoResponse = browserInfoDetailsService.getBrowserInfoDetails(userAgentRequest);
		return new ResponseEntity<>(browserInfoResponse, HttpStatus.OK);
	}

	@PostMapping("/useragent/v2/info")
	public ResponseEntity<BrowserDeviceOSInfoResponse> getBrowserInfoDetailsV2(@RequestBody UserAgentRequest userAgentRequest){
		BrowserDeviceOSInfoResponse browserInfoResponse = browserInfoDetailsService.getBrowserInfoDetailsV2(userAgentRequest);
		return new ResponseEntity<>(browserInfoResponse, HttpStatus.OK);
	}
	
	@PostMapping("/useragent/v3/info")
	public ResponseEntity<BrowserDeviceOSInfoResponse> getBrowserInfoDetailsV3(@RequestBody UserAgentRequest userAgentRequest){
		BrowserDeviceOSInfoResponse browserInfoResponse = browserInfoDetailsService.getBrowserInfoDetailsV3(userAgentRequest);
		return new ResponseEntity<>(browserInfoResponse, HttpStatus.OK);
	}
}