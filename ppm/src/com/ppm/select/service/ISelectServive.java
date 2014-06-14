/**
 * 
 */
package com.ppm.select.service;

import java.util.List;
import java.util.Map;

import com.ppm.select.domain.TableRow;

/**
 * @author partha
 *
 */
public interface ISelectServive {
	
	public List<TableRow> getSelectObject(Map<String, String> params);

}
