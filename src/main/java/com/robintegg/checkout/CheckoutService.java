package com.robintegg.checkout;

import com.robintegg.customer.CustomerID;

public interface CheckoutService {

	void startCheckout(Checkout checkout);

	Confirmation getConfirmation(CustomerID customerID);

	void cancelCheckout(CustomerID customerID);

	Checkout getCheckout(CustomerID customerID);

}
