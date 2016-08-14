package com.robintegg.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.catalogue.ProductRepository;
import com.robintegg.customer.CustomerID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private ProductRepository productRepository;

	private CheckoutRepository checkoutRepository;

	@Autowired
	public CheckoutServiceImpl(ProductRepository productRepository, CheckoutRepository checkoutRepository) {
		this.productRepository = productRepository;
		this.checkoutRepository = checkoutRepository;
	}

	@Override
	public Confirmation getConfirmation(CustomerID customerID) {
		Checkout checkout = checkoutRepository.getOne(customerID);
		return new Confirmation(checkout, productRepository);
	}

	@Override
	public void startCheckout(Checkout checkout) {
		if (checkoutRepository.exists(checkout.getCustomerID())) {
			checkoutRepository.delete(checkout.getCustomerID());
		}
		checkoutRepository.save(checkout);
	}

	@Override
	public void cancelCheckout(CustomerID customerID) {
		checkoutRepository.delete(customerID);
	}

	@Override
	public Checkout getCheckout(CustomerID customerID) {
		return checkoutRepository.findOne(customerID);
	}

}
