package com.tutorial.spring_boot_rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tutorial.spring_boot_rest.entity.StudentErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * @ExceptionHandler annotation used as a endpoint for handling exception Spring
	 * Boot
	 */

	// Generic Exception Handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> genericExceptionHandler(Exception e) {

		StudentErrorResponse error = new StudentErrorResponse();

		error.setErrorMessage(e.getMessage());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	// Custom Exception Handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> customExceptionHandler(
			StudentNotFoundException studentNotFoundException) {

		StudentErrorResponse error = new StudentErrorResponse();

		error.setErrorMessage(studentNotFoundException.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
