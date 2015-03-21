package com.ppm.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author partha
 * 
 * To load all the property file at time of server startup
 *
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer {

    private static Map<String, String> properties = new HashMap<String, String>();

    @Override
    protected void loadProperties(final Properties props) throws IOException {
        super.loadProperties(props);
        for (final Object key : props.keySet()) {
            properties.put((String) key, props.getProperty((String) key));
        }
    }

    public static String getProperty(final String name) {
        return properties.get(name);
    }

}