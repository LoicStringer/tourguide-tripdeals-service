package com.tourguidetripdealsservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		List<Provider> tripDealsProvidersList = tripPricerProxy.getTripDeals(tripPricerApiKey, tripPricerDto.getId(), 
				tripPricerDto.getAdultsNumber(), tripPricerDto.getChildrenNumber(), 
				tripPricerDto.getTripDuration(), tripPricerDto.getUserRewardsPointsSum());
		List<ProviderBean> tripDealsProviderBeansList = tripDealsProvidersList.parallelStream().map(p->{
			return providerMapper.mapProviderToProviderBean(p);
			//tripDealsProviderBeansList.add(tripDealsProviderBean);
		}).collect(Collectors.toList());
		return tripDealsProviderBeansList;
	}
}
