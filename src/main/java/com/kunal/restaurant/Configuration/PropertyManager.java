package com.kunal.restaurant.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.kunal.restaurant.Constants.CommonConstants;

@Component
public class PropertyManager {
	
	@Autowired
	private Environment env;
	//private static final Logger log = LoggerFactory.getLogger(PropertyManager.class);
	
	/**
	 * method to retrieve property value from .properties file
	 * 
	 * @param propertyName
	 *            name of property of type string
	 * @return property of property name
	 */
	public String getProperty(String propertyName) {
		return env.containsProperty(propertyName) ? env.getRequiredProperty(propertyName).trim() : CommonConstants.STR_EMPTY;
	}
	
	/**
	 * method to retrieve property value from .properties file
	 * 
	 * @param propertyName
	 *            name of property of type string
	 * @param defaultVal the default value if property is not returned
	 * @return property of property name
	 */
	public String getProperty(String propertyName, String defaultVal) {
		return env.containsProperty(propertyName) ? env.getRequiredProperty(propertyName).trim() : defaultVal;
	}

}
