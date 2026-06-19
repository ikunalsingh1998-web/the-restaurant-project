package com.kunal.restaurant.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class RecipeTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 private String uri;
	    private String label;
	    private String image;
	    private String source;
	    private String url;
	    private String shareAs;
	    private double yield;
	    private List<String> dietLabels;
	    private List<String> healthLabels;
	    private List<String> cautions;
	    private List<String> ingredientLines;
	    private List<IngredientsTO> ingredients;
	    private double calories;
	    private double totalWeight;
	    private double totalTime;
	    private List<String> cuisineType;
	    private List<String> mealType;
	    private List<String> dishType;
	    private Map<String, Object> totalNutrients;
	    private Map<String, Object> totalDaily;
	    private List<DigestTO> digest;
	    private List<String> tags;
	    
}
