package com.tourguidetripdealsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.dto.TripPricerDto;
import com.tourguidetripdealsservice.exception.TripPricerException;
import com.tourguidetripdealsservice.proxy.TripPricerProxyImpl;


@Service
public class TripDealsService {

	@Autowired
	private TripPricerProxyImpl tripPricerProxyImpl;
	
	@Value("${tripPricer.apiKey}")
	private String tripPricerApiKey;
	
	public List<ProviderBean> getTripDeals (TripPricerDto tripPricerDto) throws TripPricerException{
		return tripPricerProxyImpl.getTripDeals(tripPricerApiKey, tripPricerDto.getId(), 
				tripPricerDto.getAdultsNumber(), tripPricerDto.getChildrenNumber(), 
				tripPricerDto.getTripDuration(), tripPricerDto.getUserRewardsPointsSum());
	}
}
