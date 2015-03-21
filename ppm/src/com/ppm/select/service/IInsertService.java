package com.ppm.select.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface IInsertService {
	 String getInsert(Map<String, String> params) throws JsonParseException, JsonMappingException, IOException, ParseException;

}
