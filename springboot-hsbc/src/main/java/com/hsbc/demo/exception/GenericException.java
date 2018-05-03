package com.hsbc.demo.exception;

public class GenericException extends Exception {
	private static final long serialVersionUID = 1L;

	public GenericException(String exception) {
		super(exception);
	}

	public GenericException() {
		super();
	}
}
