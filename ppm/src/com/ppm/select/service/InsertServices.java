package com.ppm.select.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ppm.common.spring.SpringConstants;
import com.ppm.select.dao.InsertDao;

@Service
@Scope(SpringConstants.SPRING_SCOPE_PROTOTYPE)
public class InsertServices implements IInsertService {
	
	private static final  String INSERT_JSON="insertJSON";
	private static final  String QUERY_NAME="queryName";
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	@Autowired
	InsertDao insertDao;

	@Override
	public String getInsert(Map<String, String> paramMap) throws JsonParseException, JsonMappingException, IOException, ParseException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> parameterMap = new HashMap<String,Object>();
	
				//	String jSONString=paramMap.get(INSERT_JSON);
				//	jSONString.replaceAll("\"", "\"");
				String queryName=paramMap.get(QUERY_NAME);
		for(String str:paramMap.keySet()){
			if(str.startsWith("tbParam"))
			{
				/*if(str.endsWith("Date"))
				{
					String strDate=(String)paramMap.get(str);
					Date date = formatter.parse(strDate);
					parameterMap.put(str, (String)paramMap.get(str));
				}
				if(str.endsWith("Int"))
				{
					
					parameterMap.put(str, Integer.parseInt(paramMap.get(str)));
				}*/
				parameterMap.put(str, (String)paramMap.get(str));
			}
		}
		return insertDao.insertTable(parameterMap, queryName);
	}

}
