package com.hsbc.demo.model;

public class ErrorMessage {
	private String type;
	private String statusCode;
	private String message;

	public ErrorMessage() {
	}

	public ErrorMessage(String type, String statusCode, String message) {
		this.type = type;
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
