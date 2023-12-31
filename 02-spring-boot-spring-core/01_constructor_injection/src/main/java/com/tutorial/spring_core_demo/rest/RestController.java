package com.tutorial.spring_core_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.tutorial.spring_core_demo.interfaces.Coach;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private Coach myCoach;
	
	@Autowired
	public RestController(Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	

}
