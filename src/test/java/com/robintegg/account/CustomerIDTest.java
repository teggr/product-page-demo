package com.robintegg.account;

import org.junit.Test;

public class CustomerIDTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireACustomerID() {
		new CustomerID(null);
	}

}
