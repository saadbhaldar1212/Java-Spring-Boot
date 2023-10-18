package com.tutorial.spring_boot_rest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@GetMapping("/test")
	public String testRest() {
		return "RESTful successful";
	}
}
