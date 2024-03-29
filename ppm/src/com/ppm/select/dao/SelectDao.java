package com.ppm.select.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ppm.common.PropertiesUtil;
import com.ppm.common.dao.BaseDao;
import com.ppm.select.domain.TableRow;
import com.ppm.select.rowMapper.SelectRowMapper;
import com.ppm.common.spring.SpringConstants;

@Repository
@Scope(SpringConstants.SPRING_SCOPE_PROTOTYPE)
public class SelectDao extends BaseDao {
	private static final  String QUERY_NAME="queryName";
	
	public List<TableRow> getSelectList(Map<String, String> paramMap)
	{
		
		System.out.println(paramMap);
		String sql=PropertiesUtil.getProperty(paramMap.get(QUERY_NAME));
		String replace="";
		String replaced="";
		for(String str:paramMap.keySet()){
			if(str.startsWith("inOp")||str.startsWith("ph"))
			{
				replace="@"+str+"@";
				replaced=paramMap.get(str);
				sql=sql.replaceAll(replace, replaced);
			}
		}
		List<TableRow> ls=namedParameterJdbcTemplate.query(sql, paramMap, new SelectRowMapper() );
		return ls;
	}

}
