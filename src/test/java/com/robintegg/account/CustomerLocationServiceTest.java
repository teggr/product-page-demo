package com.robintegg.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerLocationServiceTest {

	@Autowired
	CustomerLocationService service;

	@Test
	public void shouldGetCustomerHomeLocationWhereCustomerExists() throws UnknownCustomerException {

		HomeLocation location = service.getLocationForCustomer(new CustomerID("robin"));

		assertEquals("LONDON", location.getLocationID());

	}

	@Test
	public void shouldReturnNoLocationWhereCustomerExistsButDoesNotHaveLocation() throws UnknownCustomerException {

		HomeLocation location = service.getLocationForCustomer(new CustomerID("alex"));

		assertNull(location);

	}

	@Test
	public void shouldThrowExceptionWhereCustomerDoesNoExist() {

		try {
			service.getLocationForCustomer(new CustomerID("dave"));
			fail("should have thrown an exception");
		} catch (UnknownCustomerException e) {

		}

	}

}
