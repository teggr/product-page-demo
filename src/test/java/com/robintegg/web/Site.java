package com.robintegg.web;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ui-test")
@Component
public class Site {

	private WebDriver driver;
	private int localServerPort;

	@Autowired
	public Site(WebDriverProvider provider) {
		this.driver = provider.getDriver();
		this.localServerPort = provider.getLocalServerPort();
	}

	public ProductPage getProductPage() {
		return new ProductPage(driver, localServerPort);
	}

	public void resetCustomerIDCookie(String customerID) {

		driver.get("http://127.0.0.1:" + localServerPort);
		Options manage = driver.manage();
		manage.deleteAllCookies();
		Cookie ck = new Cookie("customerID", customerID);
		manage.addCookie(ck);

	}

	public ConfirmationPage getConfirmationPage() {
		return new ConfirmationPage(driver, localServerPort);
	}

}
