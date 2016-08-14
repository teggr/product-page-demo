package com.robintegg.webstore;

import java.util.Collection;

import com.robintegg.account.CustomerID;
import com.robintegg.sales.Product;
import com.robintegg.sales.ProductRepository;

public class Confirmation {

	private Collection<Product> products;
	private CustomerID customerID;

	public Confirmation(Checkout checkout, ProductRepository productRepository) {
		customerID = checkout.getCustomerID();
		products = productRepository.findAll(checkout.getProductIDs());
	}

	public CustomerID getCustomerID() {
		return customerID;
	}

	public Collection<Product> getProducts() {
		return products;
	}

}
