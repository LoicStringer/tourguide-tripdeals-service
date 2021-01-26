package com.tourguidetripdealsservice.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.tourguidetripdealsservice.bean.ProviderBean;

import tripPricer.Provider;

class ProviderMapperTest {

	private ProviderMapper providerMapper;
	
	@Test
	void test() {
		providerMapper= new ProviderMapper();
		Provider provider = new Provider(UUID.randomUUID(),"Belleville FairyTail",3400);
		ProviderBean providerBean = providerMapper.mapProviderToProviderBean(provider);
		assertEquals(3400, providerBean.getPrice());
	}

}
