package com.tutorial.spring_core_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tutorial.spring_core_demo.util.ChessCoach;
import com.tutorial.spring_core_demo.util.Coach;

@Configuration
public class ChessCoachConfig {
	
//	@Bean
	@Bean("chessCoach")
	public Coach chessCoach() {
		return new ChessCoach();
	}
}
