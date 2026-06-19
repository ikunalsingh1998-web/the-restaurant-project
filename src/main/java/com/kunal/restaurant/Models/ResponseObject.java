package com.kunal.restaurant.Models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseObject<T> {

	private String statusCode;
	private String message;
	private T responsePayload;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(T responsePayload) {
		this.responsePayload = responsePayload;
	}

}
