package com.robintegg.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends Page {

	public ConfirmationPage(WebDriver driver, int localServerPort) {
		super(driver, localServerPort);
	}

	public boolean isCurrentPage() {
		return isCurrentUrl("/confirmation");
	}

	public boolean isShowingProduct(String productID) {
		return driver.findElements(By.className("confirm-product")).stream()
				.anyMatch(e -> e.getText().contains(productID));
	}

}
