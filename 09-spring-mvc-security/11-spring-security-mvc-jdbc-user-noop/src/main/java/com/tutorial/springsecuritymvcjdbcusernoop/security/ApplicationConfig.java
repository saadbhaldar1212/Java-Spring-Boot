package com.tutorial.springsecuritymvcjdbcusernoop.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationConfig {
	
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		// Custom Tables
		/*
//		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
//		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
//		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
		
//		return jdbcUserDetailsManager;
 		*/
		
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				configurer -> 
					configurer
						.requestMatchers("/").hasRole("EMPLOYEE")
						.requestMatchers("/leaders/**").hasRole("MANAGER")
						.requestMatchers("/systems/**").hasRole("ADMIN")
						.anyRequest().authenticated()
				)
		
			.formLogin(
					form ->
						form
							.loginPage("/login-page")
							.loginProcessingUrl("/userAuthentication")
							.permitAll()
					)
			
			.logout(logout -> logout.permitAll())
	                
			.exceptionHandling(
					configurer ->
	                        configurer.accessDeniedPage("/access-denied")
	                );
		
		return http.build();
		
	}

}
