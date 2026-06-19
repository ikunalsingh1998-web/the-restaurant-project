package com.kunal.restaurant.Models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class EdamamResponseForRecipeSearch implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String q;
    private Integer from;
	private Integer to;
	private Boolean more;
	private double count;
	private List<HitsTo> hits;

}
