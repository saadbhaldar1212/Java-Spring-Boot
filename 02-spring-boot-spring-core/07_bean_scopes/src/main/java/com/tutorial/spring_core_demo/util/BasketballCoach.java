package com.tutorial.spring_core_demo.util;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BasketballCoach implements Coach{
	
	public BasketballCoach() {
		System.out.println("In constuctor: -" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Jumping practise for 30 mins";
	}

}
