package com.tourguidetripdealsservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.dto.TripPricerDto;
import com.tourguidetripdealsservice.exception.TripPricerException;
import com.tourguidetripdealsservice.proxy.TripPricerProxyImpl;

@ExtendWith(MockitoExtension.class)
class TripDealsServiceTest {

	@Mock
	private TripPricerProxyImpl tripPricerProxyImpl;

	@InjectMocks
	private TripDealsService tripDealsService;

	private static TripPricerDto tripPricerDto;

	@BeforeAll
	static void setUp() {
		tripPricerDto = new TripPricerDto(UUID.randomUUID(), 2, 2, 2, 1000);
	}

	@Test
	void getTripDealsTest() throws TripPricerException {
		List<ProviderBean> tripDealsList = new ArrayList<ProviderBean>();
		ProviderBean tripDeal = new ProviderBean(UUID.randomUUID(), "Belleville FairyTail", 3400);
		ProviderBean tripDealBis = new ProviderBean(UUID.randomUUID(), "Menilmontant LeisurePark", 2500);

		tripDealsList.add(tripDeal);
		tripDealsList.add(tripDealBis);

		when(tripPricerProxyImpl.getTripDeals(null, tripPricerDto.getId(), tripPricerDto.getAdultsNumber(),
				tripPricerDto.getChildrenNumber(), tripPricerDto.getTripDuration(),
				tripPricerDto.getUserRewardsPointsSum())).thenReturn(tripDealsList);

		assertEquals("Belleville FairyTail", tripDealsService.getTripDeals(tripPricerDto).get(0).getProviderName());
	}

	@Test
	void isExpectedExceptionthrownWhenProviderBeanListIsNullTest() throws TripPricerException {
		when(tripPricerProxyImpl.getTripDeals(null, tripPricerDto.getId(), tripPricerDto.getAdultsNumber(),
				tripPricerDto.getChildrenNumber(), tripPricerDto.getTripDuration(),
				tripPricerDto.getUserRewardsPointsSum())).thenThrow(TripPricerException.class);
		assertThrows(TripPricerException.class,()->tripDealsService.getTripDeals(tripPricerDto));
	}
}
