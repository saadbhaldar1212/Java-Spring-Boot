package com.tutorial.spring_core_demo.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements Coach{
	
	public BasketballCoach() {
		System.out.println("In constuctor: -" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Jumping practise for 30 mins";
	}

}
