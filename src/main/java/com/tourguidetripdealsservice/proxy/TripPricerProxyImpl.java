package com.tourguidetripdealsservice.proxy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.exception.TripPricerException;
import com.tourguidetripdealsservice.mapper.ProviderMapper;

import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class TripPricerProxyImpl implements ITripPricerProxy{
	
	@Autowired
	private TripPricer tripPricer;
	
	@Autowired
	private ProviderMapper providerMapper;

	@Override
	public List<ProviderBean> getTripDeals(String apiKey, UUID id, int adults, int children, int duration, int rewardPoints) throws TripPricerException {
		List<Provider> tripDealsProvidersList = tripPricer.getPrice(apiKey, id, adults, children, duration, rewardPoints);
		if(tripDealsProvidersList==null||tripDealsProvidersList.isEmpty())
			throw new TripPricerException("A problem occurred with the external library \"TripPricer\" : can't retrieve the trip deals list.");
		List<ProviderBean> tripDealsProviderBeansList = tripDealsProvidersList.stream()
				.map(p->providerMapper.mapProviderToProviderBean(p))
				.collect(Collectors.toList());
		return tripDealsProviderBeansList;
	}
	
	

}
