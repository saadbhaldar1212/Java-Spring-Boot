package com.tutorial.spring_core_demo.util;

import org.springframework.stereotype.Component;

@Component
public class CarromCoach implements Coach{
	
	public CarromCoach() {
		System.out.println("In constuctor: -" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Carrom Practise for 15 mins";
	}
}
