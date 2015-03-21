package com.ppm.common.spring;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.SessionScope;

/**
 * @author partha
 * 
 * Spring Util call
 *
 */
public class SpringUtil {
	
	private static ClassPathXmlApplicationContext context = getDefaultContext();
	
	private static  ClassPathXmlApplicationContext getDefaultContext(){
		
		context = new ClassPathXmlApplicationContext(new String[] {"classpath:config/application-config.xml"});
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Scope requestScope= new RequestScope();
        beanFactory.registerScope("request", requestScope);
        Scope sessionScope= new SessionScope();
        beanFactory.registerScope("session", sessionScope);
        return context;
	}
	
	public static ClassPathXmlApplicationContext getContext(){
		return context;
		
	}

}
