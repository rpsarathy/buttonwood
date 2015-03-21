package com.ppm.select.rowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.ppm.select.domain.TableRow;

public class SelectRowMapper implements RowMapper<TableRow>{

	@Override
	public TableRow mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		
		ResultSetMetaData resultSetMetaData=  rs.getMetaData();
		TableRow tableRow=new TableRow();
		 int count=resultSetMetaData.getColumnCount();
		 for (int i=1; i<=count;i++){
			 String columnName=resultSetMetaData.getColumnName(i);
			 tableRow.addColumn(columnName, rs.getString(columnName));
			 
		 }
		
		return tableRow;
	}



}
