package com.robintegg.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ui-test")
@Component
public class WebDriverProvider implements DisposableBean {

	private static final Logger log = LoggerFactory.getLogger(WebDriverProvider.class);

	private WebDriver driver;

	private int localServerPort = 8080;

	public WebDriverProvider() {

		String webdriverChromeDriver = System.getProperty("maven.webdriver.chrome.driver",
				"C:\\tools\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", webdriverChromeDriver);
		driver = new ChromeDriver(DesiredCapabilities.chrome());

		log.info("Starting WebDriver {} against application port {}", driver, localServerPort);

	}

	public WebDriver getDriver() {
		return driver;
	}

	public int getLocalServerPort() {
		return localServerPort;
	}

	@Override
	public void destroy() throws Exception {

		// Close the browser. Allows this thread to terminate.
		driver.quit();

	}

}
