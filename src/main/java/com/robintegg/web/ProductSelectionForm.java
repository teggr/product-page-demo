package com.robintegg.web;

import java.util.HashMap;
import java.util.Map;

import com.robintegg.checkout.Checkout;

public class ProductSelectionForm {

	private Map<String, String> selections = new HashMap<>();

	public ProductSelectionForm() {
		// for empty form
	}

	public ProductSelectionForm(Checkout checkout) {
		for (String productID : checkout.getProductIDs()) {
			selections.put(productID, productID);
		}
	}

	public Map<String, String> getSelections() {
		return selections;
	}

	public boolean isSelected(String productID) {
		return selections.containsKey(productID);
	}

	@Override
	public String toString() {
		return "ProductSelectionForm [selections=" + selections + "]";
	}

}
