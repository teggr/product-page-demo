package com.robintegg.location;

import javax.persistence.Embeddable;

@Embeddable
public class Location {

	public static final Location ANY_LOCATION = new Location("ALL");

	private String locationID;

	Location() {
		// for JPA
	}

	public Location(String locationID) {
		this.locationID = locationID;
	}

	public String getLocationID() {
		return locationID;
	}

}
