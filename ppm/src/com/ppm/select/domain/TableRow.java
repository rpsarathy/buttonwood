package com.ppm.select.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TableRow {
	

	private Map<String, String> coulmns= new HashMap<String, String>();
	
	public void addColumn(String columnName,String columnValue) {
		coulmns.put(columnName, columnValue);
	}
	public Object getColumnValue(String columnValue) {
		
		return this.coulmns.get(columnValue);
	}
	
	public Set<String> getColumns()
	{
		return coulmns.keySet();
	}
	public Map<String, String> getCoulmns() {
		return coulmns;
	}
	
	
	

}
