package com.ppm.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController  {

	 @RequestMapping(value = "/testing", method = { RequestMethod.GET, RequestMethod.POST })
	    public String index() {
		 System.out.println("testing");
	        return "test get";
	    }
	 
	    @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public String create() {
	 
	     return "test put";
	     
	    }
}
