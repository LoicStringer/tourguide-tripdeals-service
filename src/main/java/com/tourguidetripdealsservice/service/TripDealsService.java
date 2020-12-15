package com.tourguidetripdealsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.dto.TripPricerDto;
import com.tourguidetripdealsservice.mapper.ProviderMapper;
import com.tourguidetripdealsservice.proxy.TripPricerProxy;

import tripPricer.Provider;

@Service
public class TripDealsService {

	@Autowired
	private TripPricerProxy tripPricerProxy;
	
	@Autowired
	private ProviderMapper providerMapper;
	
	@Value("${tripPricer.apiKey}")
	private String tripPricerApiKey;
	
	public List<ProviderBean> getTripDeals (TripPricerDto tripPricerDto){
		List<ProviderBean> tripDealsProviderBeansList = new ArrayList<ProviderBean>();
		List<Provider> tripDealsProvidersList = tripPricerProxy.getTripDeals(tripPricerApiKey, tripPricerDto.getId(), 
				tripPricerDto.getAdultsNumber(), tripPricerDto.getChildrenNumber(), 
				tripPricerDto.getTripDuration(), tripPricerDto.getUserRewardsPointsSum());
		tripDealsProvidersList.stream().forEach(p->{
			ProviderBean tripDealsProviderBean = providerMapper.mapProviderToProviderBean(p);
			tripDealsProviderBeansList.add(tripDealsProviderBean);
		});
		return tripDealsProviderBeansList;
	}
}
