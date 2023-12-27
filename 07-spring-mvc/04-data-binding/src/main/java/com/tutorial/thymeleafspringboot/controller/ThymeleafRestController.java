package com.tutorial.thymeleafspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.thymeleafspringboot.model.Registration;

// import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafRestController {

	@Value("${COUNTRIES}")
	public List<String> countries;
	
	@Value("${FAVOURITE_PROGRAMMING_LANGUAGE}")
	public List<String> favouriteProgrammingLanguages;
	
	@Value("${HOBBIES}")
	public List<String> hobbies;
	
	@GetMapping("/showRegistrationForm")
	public String showForm(Model model) {
		
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		
		model.addAttribute("countries", countries);
		model.addAttribute("favouriteProgrammingLanguages", favouriteProgrammingLanguages);
		model.addAttribute("hobbies", hobbies);
		
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processForm(@ModelAttribute("registration") Registration registration) {
		return "registration-confirmation";
	}

}
