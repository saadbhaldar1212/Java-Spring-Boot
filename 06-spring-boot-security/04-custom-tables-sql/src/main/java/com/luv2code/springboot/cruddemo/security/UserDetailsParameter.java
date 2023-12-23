package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

public class UserDetailsParameter {
	public DataSource dataSource;

	public UserDetailsParameter(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}