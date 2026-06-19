package com.kunal.restaurant.boilerplate.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kunal.restaurant.Configuration.PropertyManager;

@Component
public class CommonUtils {
	
	@Autowired
	PropertyManager propertyManager;
	
	/**
	 * Method to construct URL
	 * 
	 * @param url
	 *            url of type String
	 * @return constructedURL the string of url which is constructed
	 */
	public String constructURL(String... url) {
		StringBuilder constructedURL = new StringBuilder();
		for (String urlPart : url)
			constructedURL.append(propertyManager.getProperty(urlPart, urlPart));
		return constructedURL.toString();
	}

}
