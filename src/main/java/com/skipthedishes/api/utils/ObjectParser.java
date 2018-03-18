package com.skipthedishes.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Contains functions related to Object Parsing and Object manipulation
 * @author marcelluiz
 *
 */
public class ObjectParser {
	
	/**
	 * Converts a given Object to its String-JSON format using Jackson's writer
	 * 
	 * @param object
	 * @return String representing
	 * @throws JsonProcessingException
	 */
	public static String jsonify(Object object) throws JsonProcessingException {
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		String jsonifiedObject = ow.writeValueAsString(object);
		return jsonifiedObject;
	}

}
