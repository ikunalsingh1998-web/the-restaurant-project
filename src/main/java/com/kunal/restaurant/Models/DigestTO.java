package com.kunal.restaurant.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class DigestTO {
	
	private String label;
    private String tag;
    private String schemaOrgTag;
    private double total;
    private boolean hasRDI;
    private double daily;
    private String unit;
    private List<SubDigest> sub;

}
