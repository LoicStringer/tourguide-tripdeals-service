package com.tourguidetripdealsservice.proxy;

import java.util.List;
import java.util.UUID;

import tripPricer.Provider;

public interface ITripPricerProxy {

	List<Provider> getTripDeals(String apiKey, UUID id, int adults, int children, int duration,
			int rewardPoints);
	
}
