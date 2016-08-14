package com.robintegg.checkout;

import java.util.Collection;

import com.robintegg.catalogue.Product;
import com.robintegg.catalogue.ProductRepository;
import com.robintegg.customer.CustomerID;

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
