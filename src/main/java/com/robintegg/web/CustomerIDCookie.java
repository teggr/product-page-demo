package com.robintegg.web;

import com.robintegg.account.CustomerID;

public class CustomerIDCookie {

	private CustomerID customerID;

	public CustomerIDCookie(String customerID) {

		try {
			this.customerID = new CustomerID(customerID);
		} catch (IllegalArgumentException e) {
			throw new NoCustomerIDCookieException();
		}

	}

	public CustomerID getCustomerID() {
		return customerID;
	}

}
