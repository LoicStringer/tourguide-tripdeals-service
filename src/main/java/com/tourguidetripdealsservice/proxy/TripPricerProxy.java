package com.tourguidetripdealsservice.proxy;

import java.util.List;

import org.springframework.stereotype.Service;

import tripPricer.Provider;

@Service
public class TripPricerProxy implements ITripPricerProxy{

	@Override
	public List<Provider> getTripDeals() {
	
		return null;
	}
	
	

}
