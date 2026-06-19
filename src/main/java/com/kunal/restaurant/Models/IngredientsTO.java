package com.kunal.restaurant.Models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class IngredientsTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String text;
	String quantity;
	String measure;
	String food;
	String weight;
	String foodCategory;
	String foodId;
	String image;

}
