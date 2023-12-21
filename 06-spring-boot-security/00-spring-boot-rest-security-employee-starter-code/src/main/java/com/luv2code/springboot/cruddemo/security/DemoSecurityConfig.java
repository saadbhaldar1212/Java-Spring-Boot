package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails saad = User.builder().username("saad").password("{noop}saad1212").roles("EMPLOYEE").build();
		UserDetails mary = User.builder().username("mary").password("{noop}mary1212").roles("EMPLOYEE", "MANAGER").build();
		UserDetails susan = User.builder().username("susan").password("{noop}susan1212").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
		
		return new InMemoryUserDetailsManager(saad, mary, susan);
	}

}
