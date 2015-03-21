package com.ppm.select.dao;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ppm.common.PropertiesUtil;
import com.ppm.common.dao.BaseDao;
import com.ppm.common.spring.SpringConstants;
@Repository
@Scope(SpringConstants.SPRING_SCOPE_PROTOTYPE)
public class InsertDao extends BaseDao {

	
	
	public String insertTable(Map<String, Object> paramMap,String queryName)
	{
		
	//	System.out.println(paramMap);
		String sql=PropertiesUtil.getProperty(queryName);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameters = new MapSqlParameterSource().addValues(paramMap);

		namedParameterJdbcTemplate.update(sql, parameters, keyHolder);
		int pkid=keyHolder.getKey().intValue();
		return String.valueOf(pkid);
	}
}
