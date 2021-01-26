package com.tourguidetripdealsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TripPricerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TripPricerException(String message) {
		super(message);
	}

	
}
