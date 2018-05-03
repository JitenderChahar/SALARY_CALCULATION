package com.hsbc.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.demo.model.ErrorMessage;

public class Utils {

	public static String prepareErrorResponse(String type, String statusCode,
			String message) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setType(type);
		errorMessage.setStatusCode(statusCode);
		errorMessage.setMessage(message);
		return Utils.convertObjectToJsonString(errorMessage);
	}

	public static String convertObjectToJsonString(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			System.out.println(e);
		}
		return jsonInString;
	}
}
