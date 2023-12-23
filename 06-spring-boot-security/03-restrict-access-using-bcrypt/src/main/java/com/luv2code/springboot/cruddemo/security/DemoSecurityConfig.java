package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
		
	@Bean
	public UserDetailsManager userDetails(DataSource dataSource) {
		
		// JDBC authentication
		return new JdbcUserDetailsManager(dataSource);
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
