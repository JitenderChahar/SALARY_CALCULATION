package com.hsbc.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hsbc.demo.constant.Constants;
import com.hsbc.demo.utils.Utils;

@ControllerAdvice
public class GlobalExceptionHander {

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<String> handleDataNotFoundException(
			DataNotFoundException dataNotFoundException) {
		String message = Constants.DATA_NOT_AVAILABLE_ERROR_MSG;
		if (dataNotFoundException.getMessage() != null) {
			message = dataNotFoundException.getMessage();
		}
		String json = Utils.prepareErrorResponse("DataNotFoundException",
				Constants.DATA_NOT_AVAILABLE_ERROR, message);
		return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = GenericException.class)
	public ResponseEntity<String> handleGenericException(
			GenericException genericException) {
		String message = Constants.GENERIC_ERROR_MSG;
		if (genericException.getMessage() != null) {
			message = genericException.getMessage();
		}
		String json = Utils.prepareErrorResponse("GenericException",
				Constants.INTERNAL_SERVER_ERROR, message);
		return new ResponseEntity<>(json, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}