package com.ppm.select.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ppm.common.spring.SpringConstants;
import com.ppm.select.dao.InsertDao;
import com.ppm.select.dao.UpdateDeleteDao;

/**
 * @author partha
 *
 */
@Service
@Scope(SpringConstants.SPRING_SCOPE_PROTOTYPE)
public class UpdateService implements IUpdateService {

	private static final  String INSERT_JSON="insertJSON";
	private static final  String QUERY_NAME="queryName";
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	@Autowired
	UpdateDeleteDao updateDeleteDao;
	@Override
	public String getUpdate(Map<String, String> paramMap)
			throws JsonParseException, JsonMappingException, IOException,
			ParseException {
		// TODO Auto-generated method stub
		Map<String,String> parameterMap = new HashMap<String,String>();

		String queryName=paramMap.get(QUERY_NAME);
		for(String str:paramMap.keySet()){
			if(str.startsWith("tbParam"))
			{
			
				parameterMap.put(str, (String)paramMap.get(str));
			}
		}
		return updateDeleteDao.updateOrDelete(parameterMap, queryName);
	}

}
