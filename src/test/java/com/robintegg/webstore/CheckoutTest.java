package com.robintegg.webstore;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.robintegg.account.CustomerID;

public class CheckoutTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireACustomerID() {
		new Checkout(null, Arrays.asList("a"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireAtLeastOneProductID() {
		new Checkout(new CustomerID("robin"), new ArrayList<>());
	}

}
