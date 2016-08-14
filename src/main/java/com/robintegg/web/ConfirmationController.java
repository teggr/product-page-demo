package com.robintegg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robintegg.webstore.CheckoutService;
import com.robintegg.webstore.NoCurrentCheckoutException;

@Controller
@RequestMapping("/confirmation")
public class ConfirmationController {

	private CheckoutService checkoutService;

	@Autowired
	public ConfirmationController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getConfirmation(@CookieValue(name = "customerID", required = false) String customerIDCookie,
			Model model) throws NoCustomerIDCookieException, NoCurrentCheckoutException {

		CustomerIDCookie cookie = new CustomerIDCookie(customerIDCookie);

		model.addAttribute("checkout", checkoutService.getConfirmation(cookie.getCustomerID()));
		model.addAttribute("customerID", cookie.getCustomerID().getCustomerID());

		return "confirmation";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String cancel(@CookieValue(name = "customerID", required = false) String customerIDCookie, Model model)
			throws NoCustomerIDCookieException, NoCurrentCheckoutException {

		CustomerIDCookie cookie = new CustomerIDCookie(customerIDCookie);

		checkoutService.cancelCheckout(cookie.getCustomerID());

		return "redirect:/";
	}

}
