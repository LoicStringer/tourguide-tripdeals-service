package com.tourguidetripdealsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguidetripdealsservice.proxy.TripPricerProxy;

@Service
public class TripDealsService {

	@Autowired
	private TripPricerProxy tripPricerProxy;
	
	
	
	
}
