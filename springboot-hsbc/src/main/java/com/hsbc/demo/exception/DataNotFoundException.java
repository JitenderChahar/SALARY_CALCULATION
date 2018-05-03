package com.hsbc.demo.exception;

public class DataNotFoundException extends GenericException {
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String exception) {
		super(exception);
	}
}
