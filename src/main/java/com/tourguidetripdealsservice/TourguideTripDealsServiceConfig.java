package com.tourguidetripdealsservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tripPricer.TripPricer;

@Configuration
public class TourguideTripDealsServiceConfig {

	@Bean
	public TripPricer getTripPricer() {
		return new TripPricer();
	}
	
}
