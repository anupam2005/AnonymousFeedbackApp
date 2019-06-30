package com.idea.utility.AnonymousFeedbackApp.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTransform {
	
	private static ObjectMapper objectMapper=null;
	
	static {
		
		objectMapper = new ObjectMapper();
	}
	
	public static String java2json(Object object) {
		
		String jsonResult="";
		
		try {
			jsonResult = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			System.out.println("Exception converting object to json: "+ e.getMessage());
		}
		
		return jsonResult;
		
	}
	
	public static <T> Object json2java(String jsonString, Class<T> type) {
		
		T object = null;
		
		try {
			object = objectMapper.readValue(jsonString, type);
		} catch (JsonParseException e) {
			System.out.println("Exception converting json to object: "+ e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Exception converting json to object: "+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception converting json to object: "+ e.getMessage());
		}
		
		return object;
		
	}

}
