package com.tutorial.first.first_spring_app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	
	//expose
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/dev_tools_demo")
	public String testDevTools() {
		return "Dev Tools Started Successfully";
	}

}
