package com.kunal.restaurant.Models;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class EdamamResponseForNutritionAnalysis {

	    private String uri;
	    private int calories;
	    private double totalCO2Emissions;
	    private double totalWeight;
	    private List<String> dietLabels;
	    private List<String> healthLabels;
	    private List<String> cautions;
	    private Map<String, Object> totalNutrients;
	    private Map<String, Object> totalDaily;
	    private List<Ingredient> ingredients;
	    private Map<String, NutrientKCal> totalNutrientsKCal;

	    // Getters and setters
}


