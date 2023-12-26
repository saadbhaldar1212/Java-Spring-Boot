package com.tutorial.thymeleafspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafRestController {
	
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// Approach 1
//	@PostMapping("/processFormUsingController")
//	public String processFormUsingController(HttpServletRequest req, Model model) {
//		
//		String myName = req.getParameter("myName");
//		String toUpperCase = myName.toUpperCase();
//		
//		model.addAttribute("myName", toUpperCase);
//		
//		return "helloworld";
//	}
	
	// Approach 2 - use @RequestParam instead of HttpServletRequest
	@PostMapping("/processFormUsingController")
	public String processFormUsingController(@RequestParam("myName") String myName, Model model) {
		
		String toUpperCase = myName.toUpperCase();
		model.addAttribute("myName", toUpperCase);
		
		return "helloworld";
	}

}
