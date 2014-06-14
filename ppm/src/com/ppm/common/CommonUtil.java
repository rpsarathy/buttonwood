package com.ppm.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ppm.select.domain.TableRow;

/**
 * @author partha
 * 
 * To load all the property file at time of server startup
 *
 */
public class CommonUtil {
	
	public static Map<String, String> getParameters(HttpServletRequest request){
		
		Map<String, String> params= new HashMap<String, String>();
		Enumeration<String> paramNames=request.getParameterNames();
		
		while(paramNames.hasMoreElements()){
			String paramName=paramNames.nextElement();
			String paramValue=request.getParameter(paramName);
			params.put(paramName, paramValue);

		}
		
		return params;
	}
	
	public static String listToMap(List<TableRow> tableRows ){
		
		JSONArray jsonArray =new  JSONArray();
		for (TableRow tableRow:tableRows ){
			JSONObject jsonObj=new JSONObject();
			Map<String, String> ColumnsValues=tableRow.getCoulmns();
			jsonArray.put(ColumnsValues);
			
		}
		
		return jsonArray.toString();
	}
	

}
