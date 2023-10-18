package com.tutorial.spring_boot_rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorial.spring_boot_rest.entity.Student;
import com.tutorial.spring_boot_rest.entity.StudentErrorResponse;
import com.tutorial.spring_boot_rest.exception_handling.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

// @RequestMapping annotation is works as a start point for API creation

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	private List<Student> newStudents;
	
	/*
	 	@ExceptionHandler annotation used as a endpoint for handling exception
	 	Spring Boot
	*/
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> exceptionHandler(StudentNotFoundException studentNotFoundException) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setErrorMessage(studentNotFoundException.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// @PostConstruct used to load data at once - Bean Scope
	@PostConstruct
	public void loadData() {
		
		newStudents = new ArrayList<>();
		
		newStudents.add(new Student("Mohammad Saad", "Bhaldar"));
		newStudents.add(new Student("Aman", "Bhaldar"));
		newStudents.add(new Student("Saniya", "Bhaldar"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return newStudents; 
	}
	
	// Acessing endpoints using Path Variables
	@GetMapping("/students/{studentId}")
	public Student getStudentsById(@PathVariable int studentId) {
		
		// Throwing Exception using Custom Exception Handler class
		if((studentId >= newStudents.size()) || studentId < 0) {
			throw new StudentNotFoundException("Student not found" + studentId);
		}
		
		return newStudents.get(studentId);
	}

	/*
	 *  Jackson is automatically configured when spring-boot-starter-web 
	 	dependency is imported in the Spring Project
	 	
	 * 	Jackson works in the backend for Java POJO -> JSON conversion or
	 	vice versa will act as a getter/setter accordingly
	*/
	
	/*
	 * 	Entity class of the REST will act as a Java POJO to interact with JSON
	 	objects  
	*/
}
