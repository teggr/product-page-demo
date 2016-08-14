package com.robintegg.webstore;

import com.robintegg.account.CustomerID;

public interface CheckoutService {

	void startCheckout(Checkout checkout);

	Confirmation getConfirmation(CustomerID customerID) throws NoCurrentCheckoutException;

	void cancelCheckout(CustomerID customerID) throws NoCurrentCheckoutException;

	Checkout getCheckout(CustomerID customerID);

}
