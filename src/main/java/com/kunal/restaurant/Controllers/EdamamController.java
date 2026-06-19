package com.kunal.restaurant.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunal.restaurant.Constants.StatusConstants;
import com.kunal.restaurant.Constants.URLConstants;
import com.kunal.restaurant.Exceptions.ServiceException;
import com.kunal.restaurant.Models.EdamamResponseForNutritionAnalysis;
import com.kunal.restaurant.Models.EdamamResponseForRecipeSearch;
import com.kunal.restaurant.Models.ResponseObject;
import com.kunal.restaurant.Services.EdamamService;

@RestController
public class EdamamController {
	@Autowired
	EdamamService recipeService;
	@Autowired
	ServiceException serviceException;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = URLConstants.RECIPE_SEARCH_ENDPOINT, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ResponseObject> getRecipesFromAPI(@RequestParam(value = "recipe") String recipe) {
		ResponseObject responseObject = new ResponseObject();
			try {
				EdamamResponseForRecipeSearch recipes = recipeService.getRecipesFromAPI(recipe);
				responseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTEGER_SUCCESS));
				responseObject.setMessage(StatusConstants.MESSAGE_SUCCESS);
				responseObject.setResponsePayload(recipes);
				return new ResponseEntity<>(responseObject, HttpStatus.OK);
			} catch (ServiceException e) {
				responseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTERNAL_SERVER_ERROR));
				responseObject.setMessage(StatusConstants.MESSAGE_INTERNAL_SERVER_ERROR);
				responseObject.setResponsePayload("Error From Search Recipe Service");
				return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
			      
			}
	}
			
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@RequestMapping(value = URLConstants.NUTRITION_ANALYSIS_ENDPOINT, method = RequestMethod.GET, produces = "application/json")
			public ResponseEntity<ResponseObject> getNutritionAnalysisAPI(@RequestParam(value = "recipe") String recipe) {
				ResponseObject responseObject = new ResponseObject();
					try {
						EdamamResponseForNutritionAnalysis recipes = recipeService.getNutritionAnalysisAPI(recipe);
						responseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTEGER_SUCCESS));
						responseObject.setMessage(StatusConstants.MESSAGE_SUCCESS);
						responseObject.setResponsePayload(recipes);
						return new ResponseEntity<>(responseObject, HttpStatus.OK);
					} catch (ServiceException e) {
						responseObject.setStatusCode(String.valueOf(StatusConstants.STATUS_CODE_INTERNAL_SERVER_ERROR));
						responseObject.setMessage(StatusConstants.MESSAGE_INTERNAL_SERVER_ERROR);
						responseObject.setResponsePayload("Error From Search Recipe Service");
						return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
					      
					}

	}
	
	

}
