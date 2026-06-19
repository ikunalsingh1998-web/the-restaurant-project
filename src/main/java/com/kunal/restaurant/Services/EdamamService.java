package com.kunal.restaurant.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kunal.restaurant.Configuration.PropertyManager;
import com.kunal.restaurant.Constants.CommonConstants;
import com.kunal.restaurant.Constants.URLConstants;
import com.kunal.restaurant.Exceptions.ServiceException;
import com.kunal.restaurant.Implementations.ComponentServiceForEdamam;
import com.kunal.restaurant.Models.EdamamResponseForNutritionAnalysis;
import com.kunal.restaurant.Models.EdamamResponseForRecipeSearch;
import com.kunal.restaurant.boilerplate.utils.CommonUtils;

@Service
public class EdamamService {

	@Autowired
	ComponentServiceForEdamam componentServiceForEdamam;
	@Autowired
	CommonUtils commonUtils;
	@Autowired
	PropertyManager propertyManager;

	HttpEntity<String> headers = null;
	private final ObjectMapper objectMapper; // Jackson ObjectMapper

	@Autowired
	public EdamamService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	// Add headers if needed
	// headers.add("Authorization", "Bearer token");

	// Create HttpEntity with headers
	// HttpEntity<String> requestEntity = new HttpEntity<>(headers);

	public EdamamResponseForRecipeSearch getRecipesFromAPI(String recipe) throws ServiceException {
		String edamamUrl = commonUtils.constructURL(propertyManager.getProperty(URLConstants.URL_EDAMAM_HOST),
				URLConstants.EDAMAM_RECIPE_SEARCH_API, CommonConstants.STR_QUESTION_MARK, CommonConstants.STR_Q,
				CommonConstants.STR_EQUAL, recipe, CommonConstants.STR_AND, CommonConstants.EDAMAM_APPLICATION_ID,
				CommonConstants.STR_EQUAL,
				propertyManager.getProperty(URLConstants.EDAMAM_APPLICATION_ID_RECIPE_SEARCH), CommonConstants.STR_AND,
				CommonConstants.EDAMAM_APPLICATION_KEY, CommonConstants.STR_EQUAL,
				propertyManager.getProperty(URLConstants.EDAMAM_APPLICATION_KEY_RECIPE_SEARCH));

		ResponseEntity<String> response = componentServiceForEdamam.retrieveRecipesFromEdmam(edamamUrl, HttpMethod.GET,
				headers);
		String responseBody = response.getBody();
		EdamamResponseForRecipeSearch edamamResponse = null;
		try {
			edamamResponse = objectMapper.readValue(responseBody, EdamamResponseForRecipeSearch.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return edamamResponse;
	}

	public EdamamResponseForNutritionAnalysis getNutritionAnalysisAPI(String recipe) {
		String edamamUrl = commonUtils.constructURL(propertyManager.getProperty(URLConstants.URL_EDAMAM_HOST),
				URLConstants.URL_API, URLConstants.EDAMAM_NUTRITION_ANALYSIS_API, CommonConstants.STR_QUESTION_MARK,
				URLConstants.EDAMAM_INGREDIENT_PARAM, CommonConstants.STR_EQUAL, recipe, CommonConstants.STR_AND,
				CommonConstants.EDAMAM_APPLICATION_ID, CommonConstants.STR_EQUAL,
				propertyManager.getProperty(URLConstants.EDAMAM_APPLICATION_ID_NUTRITION_ANALYSIS),
				CommonConstants.STR_AND, CommonConstants.EDAMAM_APPLICATION_KEY, CommonConstants.STR_EQUAL,
				propertyManager.getProperty(URLConstants.EDAMAM_APPLICATION_KEY_NUTRITION_ANALYSIS));

		ResponseEntity<String> response = componentServiceForEdamam.retrieveRecipesFromEdmam(edamamUrl, HttpMethod.GET,
				headers);
		String responseBody = response.getBody();
		EdamamResponseForNutritionAnalysis edamamResponse = null;
		try {
			edamamResponse = objectMapper.readValue(responseBody, EdamamResponseForNutritionAnalysis.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return edamamResponse;
	}

}
