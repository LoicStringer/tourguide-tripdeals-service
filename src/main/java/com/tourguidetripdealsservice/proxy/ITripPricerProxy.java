package com.tourguidetripdealsservice.proxy;

import java.util.List;
import java.util.UUID;

import com.tourguidetripdealsservice.bean.ProviderBean;

public interface ITripPricerProxy {

	List<ProviderBean> getTripDeals(String apiKey, UUID id, int adults, int children, int duration,
			int rewardPoints) throws Exception;
	
}
