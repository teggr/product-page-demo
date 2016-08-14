package com.robintegg.checkout;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.robintegg.customer.CustomerID;

@Entity
public class Checkout {

	@ElementCollection
	private Collection<String> productIDs;
	private boolean confirmed = false;

	@EmbeddedId
	private CustomerID customerID;

	public Checkout(CustomerID customerID, Collection<String> productIDs) {
		this.customerID = customerID;
		this.productIDs = productIDs;
		if (productIDs.isEmpty()) {
			throw new IllegalArgumentException("Can't checkout an empty basket");
		}
	}

	Checkout() {
	}

	public Collection<String> getProductIDs() {
		return productIDs;
	}

	public CustomerID getCustomerID() {
		return customerID;
	}

	public boolean isConfirmed() {
		return confirmed;
	}
}
