package com.tutorial.spring_core_demo.util;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BasketballCoach implements Coach{
	
	public BasketballCoach() {
		System.out.println("In constuctor: -" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Jumping practise for 30 mins";
	}
	
	@PostConstruct
	public void initBeanMethod() {
		System.out.println("Bean Method Initialized successfully"); 
	}
	
	@PreDestroy
	public void destroyBeanMethod() {
		System.out.println("Bean Method Destroyed successfully"); 
	}

}
