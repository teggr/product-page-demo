package com.robintegg.sales;

import javax.persistence.Embeddable;

@Embeddable
public class SalesLocation {

	public static final SalesLocation ANY_LOCATION = new SalesLocation("ALL");

	private String locationID;

	SalesLocation() {
		// for JPA
	}

	public SalesLocation(String locationID) {
		if (locationID == null) {
			throw new IllegalArgumentException("must define a location id");
		}
		this.locationID = locationID;
	}

	public String getLocationID() {
		return locationID;
	}

}
