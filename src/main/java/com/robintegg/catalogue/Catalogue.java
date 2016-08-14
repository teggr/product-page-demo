package com.robintegg.catalogue;

import java.util.Collection;
import java.util.stream.Collectors;

public class Catalogue {

	private Collection<Product> products;

	public Catalogue(Collection<Product> products) {
		this.products = products;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public Collection<Product> getProductsBy(Category category) {
		return products.stream().filter(p -> p.matchesCategory(category)).collect(Collectors.toList());
	}

}
