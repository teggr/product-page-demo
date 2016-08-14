package com.robintegg.sales;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.robintegg.common.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CatalogueServiceTest {

	@Autowired
	CatalogueService service;

	@Test
	public void shouldReturnLocationBasedProductsThatMatchNamedLocation() {

		Catalogue catalogue = service.getCatalogueForLocation(new Location("LONDON"));

		Collection<Product> products = catalogue.getProducts();
		assertEquals(4, products.size());
		assertEquals(1, products.stream().filter(p -> p.getName().equals("Arsenal TV")).count());
		assertEquals(1, products.stream().filter(p -> p.getName().equals("Chelsea TV")).count());
		assertEquals(1, products.stream().filter(p -> p.getName().equals("Sky Sport News")).count());
		assertEquals(1, products.stream().filter(p -> p.getName().equals("Sky News")).count());

	}

	@Test
	public void shouldReturnSkyProductsRegardlessOfLocation() {

		Catalogue catalogue = service.getCatalogueForLocation(new Location("TIMBUKTOO"));

		Collection<Product> products = catalogue.getProducts();
		assertEquals(2, products.size());
		assertEquals(1, products.stream().filter(p -> p.getName().equals("Sky Sport News")).count());
		assertEquals(1, products.stream().filter(p -> p.getName().equals("Sky News")).count());

	}

}
