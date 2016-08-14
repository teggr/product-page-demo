package com.robintegg.common;

import javax.persistence.Embeddable;

@Embeddable
public class Location {

	public static final Location ANY_LOCATION = new Location("ALL");

	private String locationID;

	Location() {
		// for JPA
	}

	public Location(String locationID) {
		if (locationID == null) {
			throw new IllegalArgumentException("must define a location id");
		}
		this.locationID = locationID;
	}

	public String getLocationID() {
		return locationID;
	}

}
