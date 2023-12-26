package com.tutorial.thymeleafspringboot.model;

import java.util.List;

public class Registration {

	private String firstName;
	private String lastName;
	private String country;
	private String favouriteProgrammingLanguage;
	private List<String> hobbies;

	public String getFavouriteProgrammingLanguage() {
		return favouriteProgrammingLanguage;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
		this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Registration() {
		super();
	}

}
