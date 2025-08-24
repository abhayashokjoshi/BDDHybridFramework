package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.ReadProperties;

/**
 * @author Abhay This class has common methods to Start and Close the browser.
 *
 */
public class Base {

	public static WebDriver driver;

	/**
	 * @return the driver object after launching the application URL.
	 */
	
	
	public WebDriver initializeWebDriver() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ReadProperties.implicitWaitTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ReadProperties.getappURL());
		return driver;

	}

	/**
	 * This method will close the opened browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
}
