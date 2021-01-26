package com.tourguidetripdealsservice.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.exception.TripPricerException;
import com.tourguidetripdealsservice.mapper.ProviderMapper;

import tripPricer.Provider;
import tripPricer.TripPricer;

@ExtendWith(MockitoExtension.class)
class TripPricerProxyImplTest {

	@Mock
	private TripPricer tripPricer;
	
	@Mock
	private ProviderMapper providerMapper;
	
	@InjectMocks
	private TripPricerProxyImpl tripPricerProxyImpl;
	
	@Test
	void getTripDealsTest() throws TripPricerException {
		List<Provider> tripDealsList = new ArrayList<Provider>();
		Provider tripDeal = new Provider(UUID.randomUUID(),"Belleville FairyTail",3400);
		Provider tripDealBis = new Provider(UUID.randomUUID(),"Menilmontant LeisurePark",2500);
		tripDealsList.add(tripDeal);
		tripDealsList.add(tripDealBis);
		ProviderBean tripDealBean = new ProviderBean(UUID.randomUUID(),"Belleville FairyTail",3400);
		ProviderBean tripDealBeanBis = new ProviderBean(UUID.randomUUID(),"Menilmontant LeisurePark",2500);
		
		when(tripPricer.getPrice(null, null, 2, 2, 2, 1000)).thenReturn(tripDealsList);
		when(providerMapper.mapProviderToProviderBean(tripDeal)).thenReturn(tripDealBean);
		when(providerMapper.mapProviderToProviderBean(tripDealBis)).thenReturn(tripDealBeanBis);
		
		List<ProviderBean> tripDealBeansList = tripPricerProxyImpl.getTripDeals(null, null, 2, 2, 2, 1000);
		
		assertEquals("Belleville FairyTail",tripDealBeansList.get(0).getProviderName());
	}
	
	@Test
	void isExpectedExceptionThrownWhenProviderListIsNullTest() {
		when(tripPricer.getPrice(null, null, 2, 2, 2, 1000)).thenReturn(null);
		assertThrows(TripPricerException.class,()-> tripPricerProxyImpl.getTripDeals(null, null, 2, 2, 2, 1000));
	}

}
