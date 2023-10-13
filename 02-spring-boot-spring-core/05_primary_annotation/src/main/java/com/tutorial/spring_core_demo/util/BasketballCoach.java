package com.tutorial.spring_core_demo.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketballCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Jumping practise for 30 mins";
	}

}
