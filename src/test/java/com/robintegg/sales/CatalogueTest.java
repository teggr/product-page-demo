package com.robintegg.sales;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;

public class CatalogueTest {

	@Test
	public void shouldReturnProductsFilteredByCategory() {
		Collection<Product> products = new ArrayList<>();
		products.add(new Product("a", Category.NEWS, SalesLocation.ANY_LOCATION));
		products.add(new Product("b", Category.SPORTS, SalesLocation.ANY_LOCATION));
		products.add(new Product("c", Category.NEWS, SalesLocation.ANY_LOCATION));
		products.add(new Product("d", Category.SPORTS, SalesLocation.ANY_LOCATION));
		Catalogue catalogue = new Catalogue(products);

		Collection<Product> news = catalogue.getProductsBy(Category.NEWS);
		assertEquals(2, news.size());
		assertTrue(productsContain(news, "a", "c"));

		Collection<Product> sports = catalogue.getProductsBy(Category.SPORTS);
		assertEquals(2, sports.size());
		assertTrue(productsContain(sports, "b", "d"));

		Collection<Product> undefined = catalogue.getProductsBy(null);
		assertTrue(undefined.isEmpty());
	}

	private boolean productsContain(Collection<Product> products, String... productIDs) {
		return products.stream().map(p -> p.getProductID()).collect(Collectors.toList())
				.containsAll(Arrays.asList(productIDs));
	}

}
