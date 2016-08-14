package com.robintegg.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robintegg.checkout.Checkout;
import com.robintegg.checkout.CheckoutService;
import com.robintegg.selection.ProductSelectionService;

@Controller
@RequestMapping("/")
public class ProductSelectionController {

	private static final Logger log = LoggerFactory.getLogger(ProductSelectionController.class);

	private ProductSelectionService productSelection;

	private CheckoutService checkout;

	@Autowired
	public ProductSelectionController(ProductSelectionService productSelection, CheckoutService checkout) {
		this.productSelection = productSelection;
		this.checkout = checkout;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getProductSelection(@CookieValue(name = "customerID", required = false) String customerIDCookie,
			Model model) throws NoCustomerIDCookieException {

		CustomerIDCookie cookie = new CustomerIDCookie(customerIDCookie);

		Checkout existingCheckout = checkout.getCheckout(cookie.getCustomerID());
		if (existingCheckout != null) {
			model.addAttribute("form", new ProductSelectionForm(existingCheckout));
		} else {
			model.addAttribute("form", new ProductSelectionForm());
		}

		model.addAttribute("catalogue", productSelection.getAvailableProductsCatalogue(cookie.getCustomerID()));

		return "productselection";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String selectProducts(@CookieValue(name = "customerID", required = false) String customerIDCookie,
			Model model, @ModelAttribute("form") ProductSelectionForm form, BindingResult result)
			throws NoCustomerIDCookieException {

		CustomerIDCookie cookie = new CustomerIDCookie(customerIDCookie);

		log.debug("Received selection for customer {}: {}", cookie.getCustomerID(), form);

		try {
			Checkout checkoutBasket = new Checkout(cookie.getCustomerID(), form.getSelections().values());
			checkout.startCheckout(checkoutBasket);
			return "redirect:/confirmation";
		} catch (Exception e) {
			model.addAttribute("catalogue", productSelection.getAvailableProductsCatalogue(cookie.getCustomerID()));
			return "productselection";
		}

	}

}
