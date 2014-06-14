package com.ppm.common.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ppm.common.spring.SpringUtil;


/**
 * @author partha
 * 
 * Base Dao all the Dao should extend base Dao
 *
 */
public class BaseDao {
	
	protected DataSource dataSource=getDataSource();
	
	protected JdbcTemplate jdbcTemplateObject;
	
	DataSource getDataSource(){
		return (DataSource)SpringUtil.getContext().getBean("dataSource1");
	}
	
}
