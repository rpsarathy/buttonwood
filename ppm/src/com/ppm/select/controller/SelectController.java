package com.ppm.select.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppm.common.CommonUtil;
import com.ppm.select.service.ISelectServive;
@Controller
public class SelectController {
	@Autowired
	ISelectServive selectServive;
	 @RequestMapping(value = "/select", method = { RequestMethod.GET, RequestMethod.POST })
	 @ResponseBody
	 public String Onselect(HttpServletRequest request) {
	 Map<String, String> params=CommonUtil.getParameters(request);
	 		return CommonUtil.listToMap(selectServive.getSelectObject(params));
	    }
	 

}
