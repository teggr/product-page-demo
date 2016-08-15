package com.robintegg.account;

import javax.persistence.Embeddable;

@Embeddable
public class HomeLocation {

	private String locationID;

	HomeLocation() {
		// for JPA
	}

	public HomeLocation(String locationID) {
		if (locationID == null) {
			throw new IllegalArgumentException("must define a location id");
		}
		this.locationID = locationID;
	}

	public String getLocationID() {
		return locationID;
	}

}
