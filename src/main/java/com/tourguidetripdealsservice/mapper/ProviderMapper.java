package com.tourguidetripdealsservice.mapper;

import org.springframework.stereotype.Component;

import com.tourguidetripdealsservice.bean.ProviderBean;

import tripPricer.Provider;

@Component
public class ProviderMapper {
	
	public ProviderBean mapProvider(Provider provider) {
		ProviderBean providerBean = new ProviderBean();
		providerBean.setTripId(provider.tripId);
		providerBean.setProviderName(provider.name);
		providerBean.setPrice(provider.price);
		return providerBean;
	}

}
