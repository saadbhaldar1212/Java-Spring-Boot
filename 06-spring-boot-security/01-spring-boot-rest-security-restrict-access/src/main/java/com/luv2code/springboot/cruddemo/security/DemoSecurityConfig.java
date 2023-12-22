package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails saad = User.builder().username("saad").password("{noop}saad1212").roles("EMPLOYEE").build();
		UserDetails mary = User.builder().username("mary").password("{noop}mary1212").roles("EMPLOYEE", "MANAGER").build();
		UserDetails susan = User.builder().username("susan").password("{noop}susan1212").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
		
		return new InMemoryUserDetailsManager(saad, mary, susan);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
				configurer
				.requestMatchers(HttpMethod.GET, "api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
				);
		
		// use http basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		//disable Cross Site Request Forgery (CSFR)
		// not required for stateless REST API which uses POST,PUT,DELETE
		http.csrf(csrf -> csrf.disable()); 
		
		return http.build();
		
	}
	
}
