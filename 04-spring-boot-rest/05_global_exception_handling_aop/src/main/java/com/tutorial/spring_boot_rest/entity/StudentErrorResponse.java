package com.tutorial.spring_boot_rest.entity;

public class StudentErrorResponse {
	private int statusCode;
	private String errorMessage;
	private long timeStamp;
	
	public StudentErrorResponse() {
		super();
	}

	public StudentErrorResponse(int statusCode, String errorMessage, long timeStamp) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
