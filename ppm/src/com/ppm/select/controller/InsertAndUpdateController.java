package com.ppm.select.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppm.common.CommonUtil;
import com.ppm.select.service.IInsertService;
import com.ppm.select.service.ISelectServive;
import com.ppm.select.service.IUpdateService;
import com.ppm.select.service.UpdateService;
@Controller
public class InsertAndUpdateController {

	@Autowired
	IInsertService insertService;
	@Autowired
	IUpdateService updateService;
	 @RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	 @ResponseBody
	 public String OnInsert(HttpServletRequest request) throws ParseException {
	 Map<String, String> params=CommonUtil.getParameters(request);
	 		try {
				return insertService.getInsert(params);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return "Json Error";
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Json Error";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Json Error";
			}
	    }
	 @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	 @ResponseBody
	 public String OnUpdate(HttpServletRequest request) throws ParseException {
	 Map<String, String> params=CommonUtil.getParameters(request);
	 		try {
				return updateService.getUpdate(params);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return "Json Error";
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Json Error";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Json Error";
			}
	    }
}
