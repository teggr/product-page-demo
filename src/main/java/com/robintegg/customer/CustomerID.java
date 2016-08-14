package com.robintegg.customer;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CustomerID implements Serializable {

	private String customerID;

	public CustomerID(String customerID) {
		if (customerID == null) {
			throw new IllegalArgumentException("Must define the customerID");
		}
		this.customerID = customerID;
	}

	CustomerID() {
	}

	public String getCustomerID() {
		return customerID;
	}

}
