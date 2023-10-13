package com.tutorial.spring_core_demo.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Bowling practise for 15 mins";
	}


}
