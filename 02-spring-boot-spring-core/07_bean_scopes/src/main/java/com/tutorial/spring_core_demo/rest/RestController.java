package com.tutorial.spring_core_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import com.tutorial.spring_core_demo.util.Coach;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private Coach myCoach;
	private Coach myCoach2;
	
	// Setter Injection
	/*
	@Autowired
	public void setMyCoach(Coach myCoach) {
		this.myCoach = myCoach;
	}
	*/
	
	// Constructor Injection
	@Autowired
	public RestController(@Qualifier("basketballCoach") Coach myCoach, 
			@Qualifier("basketballCoach") Coach myCoach2) {
		this.myCoach = myCoach;
		this.myCoach2 = myCoach2;
	}
	
	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/checkForBeanScope")
	public String checkBeanScope() {
//		return "Comapare both beans (Singleton): " + (myCoach == myCoach2);
		return "Comapare both beans (Prototype): " + (myCoach == myCoach2); 
	}
}
