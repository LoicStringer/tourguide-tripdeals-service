package com.tourguidetripdealsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourguidetripdealsservice.bean.ProviderBean;
import com.tourguidetripdealsservice.dto.TripPricerDto;
import com.tourguidetripdealsservice.service.TripDealsService;

@RestController
public class TripDealsServiceController {
	
	@Autowired
	private TripDealsService tripDealsService;

	@PostMapping("/trip-deals")
	public ResponseEntity<List<ProviderBean>> getTripDeals (@RequestBody TripPricerDto tripPricerDto){
		return ResponseEntity.ok(tripDealsService.getTripDeals(tripPricerDto));
	}
	
}
