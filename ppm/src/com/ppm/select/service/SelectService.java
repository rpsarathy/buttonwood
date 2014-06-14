/**
 * 
 */
package com.ppm.select.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ppm.common.spring.SpringConstants;
import com.ppm.select.dao.SelectDao;
import com.ppm.select.domain.TableRow;

/**
 * @author partha
 *
 */
@Service
@Scope(SpringConstants.SPRING_SCOPE_PROTOTYPE)
public class SelectService implements ISelectServive {
	
	@Autowired
	private SelectDao selectDao;

	@Override
	public List<TableRow> getSelectObject(Map<String, String> params) {
		
		
		return selectDao.getSelectList(params);	
		
	}
	
	

}
