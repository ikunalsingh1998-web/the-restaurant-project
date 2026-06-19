package com.kunal.restaurant.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity noDataFound() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
