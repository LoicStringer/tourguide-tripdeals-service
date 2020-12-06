package com.tourguidetripdealsservice.proxy;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerProxy implements ITripPricerProxy{
	
	@Autowired
	private TripPricer tripPricer;

	@Override
	public List<Provider> getTripDeals(String apiKey, UUID tripId, int adults, int children, int duration, int rewardPoints) {
		List<Provider> providers = tripPricer.getPrice(apiKey, tripId, adults, children, duration, rewardPoints);
		return providers;
	}
	
	

}
