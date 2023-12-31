package com.tutorial.first.first_spring_app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	
	//expose values from application properties
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/app-info")
	public String appInfo() {
		return "App name: " + appName + ", App Version: " + appVersion;
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/dev_tools_demo")
	public String testDevTools() {
		return "Dev Tools Started Successfully";
	}
}
