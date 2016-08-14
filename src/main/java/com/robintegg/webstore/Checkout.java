package com.robintegg.webstore;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.robintegg.account.CustomerID;

@Entity
public class Checkout {

	@ElementCollection
	private Collection<String> productIDs;

	@EmbeddedId
	private CustomerID customerID;

	public Checkout(CustomerID customerID, Collection<String> productIDs) {
		if (customerID == null) {
			throw new IllegalArgumentException("a customer is required for a check out");
		}
		if (productIDs.isEmpty()) {
			throw new IllegalArgumentException("Can't checkout an empty basket");
		}
		this.customerID = customerID;
		this.productIDs = productIDs;
	}

	Checkout() {
	}

	public Collection<String> getProductIDs() {
		return productIDs;
	}

	public CustomerID getCustomerID() {
		return customerID;
	}

}
