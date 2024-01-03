package com.tutorial.springsecuritymvcjdbcusernoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/login-page")
	public String loginPage() {
		return "login-page";
	}

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	// add a request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {

		return "leaders";
	}

	// add request mapping for /systems
	@GetMapping("/systems")
	public String showSystems() {

		return "systems";
	}

	// add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {

		return "/error/access-denied";
	}
}
