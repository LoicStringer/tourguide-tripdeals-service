package com.tourguidetripdealsservice.mapper;

import org.springframework.stereotype.Service;

import com.tourguidetripdealsservice.bean.ProviderBean;

import tripPricer.Provider;

@Service
public class ProviderMapper {

	public ProviderBean mapProviderToProviderBean(Provider provider) {
		ProviderBean providerBean = new ProviderBean();
		providerBean.setTripId(provider.tripId);
		providerBean.setProviderName(provider.name);
		providerBean.setPrice(provider.price);
		return providerBean;
	}
	

}
