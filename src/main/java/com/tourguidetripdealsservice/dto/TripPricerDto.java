package com.tourguidetripdealsservice.dto;

import java.util.UUID;

public class TripPricerDto {

	private UUID id;
	private int adultsNumber;
	private int childrenNumber;
	private int tripDuration;
	private int userRewardsPointsSum;
	
	public TripPricerDto() {
	}

	public TripPricerDto(UUID id, int adultsNumber, int childrenNumber, int tripDuration, int userRewardsPointsSum) {
		super();
		this.id = id;
		this.adultsNumber = adultsNumber;
		this.childrenNumber = childrenNumber;
		this.tripDuration = tripDuration;
		this.userRewardsPointsSum = userRewardsPointsSum;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getAdultsNumber() {
		return adultsNumber;
	}

	public void setAdultsNumber(int adultsNumber) {
		this.adultsNumber = adultsNumber;
	}

	public int getChildrenNumber() {
		return childrenNumber;
	}

	public void setChildrenNumber(int childrenNumber) {
		this.childrenNumber = childrenNumber;
	}

	public int getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(int tripDuration) {
		this.tripDuration = tripDuration;
	}

	public int getUserRewardsPointsSum() {
		return userRewardsPointsSum;
	}

	public void setUserRewardsPointsSum(int userRewardsPointsSum) {
		this.userRewardsPointsSum = userRewardsPointsSum;
	}

	
}
