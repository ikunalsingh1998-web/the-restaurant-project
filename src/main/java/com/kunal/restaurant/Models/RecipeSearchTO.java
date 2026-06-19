package com.kunal.restaurant.Models;

import java.util.List;

import lombok.Data;

@Data
public class RecipeSearchTO {

	String Cuisine;
	String Results;
	List<RecipesTO> Recipes;

}
