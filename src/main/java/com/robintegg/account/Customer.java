package com.robintegg.account;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.robintegg.common.Location;

@Entity
public class Customer {

	@EmbeddedId
	public CustomerID customerID;

	@Embedded
	private Location homeLocation;

	public Customer(CustomerID customerID) {
		this(customerID, null);
	}

	public Customer(CustomerID customerID, Location homeLocation) {
		super();
		if (customerID == null) {
			throw new IllegalArgumentException("Must have a customerID");
		}
		this.customerID = customerID;
		this.homeLocation = homeLocation;
	}

	Customer() {
	}

	public CustomerID getCustomerID() {
		return customerID;
	}

	public Location getHomeLocation() {
		return homeLocation;
	}

}
