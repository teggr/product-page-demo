package com.robintegg.webstore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.robintegg.account.CustomerID;
import com.robintegg.account.UnknownCustomerException;
import com.robintegg.sales.Catalogue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductSelectionServiceImplTest {

	@Autowired
	ProductSelectionService service;

	@Test
	public void shouldGetProductsForCustomerWithLocation() throws UnknownCustomerException {

		Catalogue catalogue = service.getAvailableProductsCatalogue(new CustomerID("robin"));

		assertEquals(4, catalogue.getProducts().size());

	}

	@Test
	public void shouldGetProductsForCustomerWithoutLocation() throws UnknownCustomerException {

		Catalogue catalogue = service.getAvailableProductsCatalogue(new CustomerID("alex"));

		assertEquals(2, catalogue.getProducts().size());

	}

	@Test(expected = UnknownCustomerException.class)
	public void shouldThrowExceptionIfCustomerUnknonw() throws UnknownCustomerException {

		service.getAvailableProductsCatalogue(new CustomerID("dave"));

	}

}
