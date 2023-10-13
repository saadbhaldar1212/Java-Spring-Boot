package com.tutorial.spring_core_demo.util;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Jumping practise for 30 mins";
	}

}
