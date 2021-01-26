package com.tourguidetripdealsservice.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.dto.TripPricerDto;
import com.tourguidetripdealsservice.exception.TripPricerException;
import com.tourguidetripdealsservice.proxy.TripPricerProxyImpl;

@SpringBootTest
@AutoConfigureMockMvc
@PropertySource("classpath:application.properties")
class TripDealsServiceTestIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private TripPricerProxyImpl tripPricerProxyImpl;

	@Value("${tripPricer.apiKey}")
	private String tripPricerApiKey;
	
	private TripPricerDto tripPricerDto;
	
	@BeforeEach
	void setUp() throws TripPricerException {
		List<ProviderBean> tripDealsList = new ArrayList<ProviderBean>();
		ProviderBean tripDeal = new ProviderBean(null, "Belleville FairyTail", 3400);
		ProviderBean tripDealBis = new ProviderBean(null, "Menilmontant LeisurePark", 2500);
		tripPricerDto = new TripPricerDto(null, 2, 2, 2, 1000);
		tripDealsList.add(tripDeal);
		tripDealsList.add(tripDealBis);

		when(tripPricerProxyImpl.getTripDeals(tripPricerApiKey, tripPricerDto.getId(), tripPricerDto.getAdultsNumber(),
				tripPricerDto.getChildrenNumber(), tripPricerDto.getTripDuration(),
				tripPricerDto.getUserRewardsPointsSum())).thenReturn(tripDealsList);
	}

	@Test
	void getTripDealsIntagrationTest() throws JsonProcessingException, Exception {

		mockMvc.perform(post("/trip-deals").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tripPricerDto))).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].providerName").value("Belleville FairyTail"));
	}

	@Test
	void isExpectedExceptionthrownWhenProviderBeanListIsNullTest() throws JsonProcessingException, Exception {
		when(tripPricerProxyImpl.getTripDeals(tripPricerApiKey, tripPricerDto.getId(), tripPricerDto.getAdultsNumber(),
				tripPricerDto.getChildrenNumber(), tripPricerDto.getTripDuration(),
				tripPricerDto.getUserRewardsPointsSum())).thenThrow(TripPricerException.class);
		
		mockMvc.perform(post("/trip-deals").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tripPricerDto)))
				.andExpect(status().isNotFound())
				.andExpect(result->assertTrue(result.getResolvedException() instanceof TripPricerException));
	}
	
}
