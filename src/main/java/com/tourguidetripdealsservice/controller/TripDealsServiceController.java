package com.tourguidetripdealsservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.dto.TripPricerDto;
import com.tourguidetripdealsservice.exception.TripPricerException;
import com.tourguidetripdealsservice.service.TripDealsService;

@RestController
public class TripDealsServiceController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TripDealsService tripDealsService;

	@PostMapping("/trip-deals")
	public ResponseEntity<List<ProviderBean>> getTripDeals (@RequestBody TripPricerDto tripPricerDto) throws TripPricerException{
		log.info("Querying Trip Pricer external API to get a list of trip deals.");
		return ResponseEntity.ok(tripDealsService.getTripDeals(tripPricerDto));
	}
	
}
