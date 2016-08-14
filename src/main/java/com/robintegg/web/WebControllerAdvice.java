package com.robintegg.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.robintegg.account.UnknownCustomerException;
import com.robintegg.webstore.NoCurrentCheckoutException;

@ControllerAdvice
public class WebControllerAdvice {

	// Convert unknown customer exceptions to 400 request errors
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "account.error.unknown.customer")
	@ExceptionHandler(UnknownCustomerException.class)
	public void unknownCustomer() {
		// Nothing to do
	}

	// Convert no cookie exceptions to 400 request errors
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "product.selection.error.nocookie")
	@ExceptionHandler(NoCustomerIDCookieException.class)
	public void noCookie() {
		// Nothing to do
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "product.selection.error.nocheckout")
	@ExceptionHandler(NoCurrentCheckoutException.class)
	public void noCurrentCheckout() {
		// Nothing to do
	}

}
