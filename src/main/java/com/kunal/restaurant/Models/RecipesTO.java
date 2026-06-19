package com.kunal.restaurant.Models;

import java.util.List;

import lombok.Data;

@Data
public class RecipesTO {

	String Name;
	String Source;
	List<String> HealthTags;
	List<String> Ingredients;
	List<IngredientListTO> IngredientList;
	String Calories;
	List<String> Cuisine;
	List<String> MealType;
	List<String> Dish;
	
}
