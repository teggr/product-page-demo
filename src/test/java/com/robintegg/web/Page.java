package com.robintegg.web;

import org.openqa.selenium.WebDriver;

public class Page {

	protected WebDriver driver;
	protected int localServerPort;

	public Page(WebDriver driver, int localServerPort) {
		this.driver = driver;
		this.localServerPort = localServerPort;
	}

	protected String toUrl(String path) {
		return "http://127.0.0.1:" + localServerPort + path;
	}

	protected boolean isCurrentUrl(String path) {
		return driver.getCurrentUrl().endsWith(path);
	}

}
