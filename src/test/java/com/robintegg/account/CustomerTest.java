package com.robintegg.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CustomerTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireACustomerID() {
		new Customer(null, null);
	}

	@Test
	public void shouldAllowOptionalLocationID() {
		Customer customer = new Customer(new CustomerID("jack"));

		assertEquals("jack", customer.getCustomerID().getCustomerID());
		assertNull(customer.getHomeLocation());
	}

}
