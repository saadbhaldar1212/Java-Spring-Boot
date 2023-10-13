package com.tutorial.spring_core_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import com.tutorial.spring_core_demo.util.Coach;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private Coach myCoach;
	
	// Setter Injection
	/*
	@Autowired
	public void setMyCoach(Coach myCoach) {
		this.myCoach = myCoach;
	}
	*/
	
	// Constructor Injection
	@Autowired
	public RestController(@Qualifier("carromCoach") Coach myCoach) {
		this.myCoach = myCoach;
	}
	
	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
