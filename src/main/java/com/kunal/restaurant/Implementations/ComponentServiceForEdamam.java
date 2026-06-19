package com.kunal.restaurant.Implementations;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kunal.restaurant.Exceptions.ServiceException;

@Service
public class ComponentServiceForEdamam {

	private final RestTemplate restTemplate;

	public ComponentServiceForEdamam(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<String> retrieveRecipesFromEdmam(String url, HttpMethod httpMethod,
			HttpEntity<String> requestEntity) throws ServiceException {
		return restTemplate.exchange(url, httpMethod, requestEntity, String.class);

	}

}
