package com.robintegg.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

	public ProductPage(WebDriver driver, int localServerPort) {
		super(driver, localServerPort);
	}

	public ProductPage navigateTo() {
		String url = toUrl("/");
		driver.navigate().to(url);
		return this;
	}

	public boolean doesWelcomeMessageContain(String customerID) {

		return driver.findElement(By.className("welcome")).getText().contains(customerID);

	}

	public void selectProduct(String productID) {

		driver.findElements(By.className("product-selector")).stream()
				.filter(e -> e.getAttribute("data-name").equals(productID)).findFirst().get().click();

	}

	public boolean isProductInBasket(String productID) {

		return driver.findElements(By.className("basket-product")).stream().filter(e -> e.getText().equals(productID))
				.findFirst().isPresent();

	}

	public boolean canCheckout() {
		return driver.findElement(By.id("submit")).isDisplayed();
	}

	public void unselectProduct(String productID) {
		selectProduct(productID);
	}

	public boolean basketIsEmpty() {
		return driver.findElements(By.className("basket-product")).isEmpty();
	}

	public void checkout() {
		driver.findElement(By.id("submit")).click();
	}

}
