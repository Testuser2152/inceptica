package com.inceptica.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.inceptica.testUtils.PropertyFileLoader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private static WebDriver driver = null;
	private TestBase() {
	}

	/**
	 * @name : getDriver
	 * @description initializing the driver and returns the webdriver instance
	 * @return - WebDriver
	 */
	public static WebDriver getDriver()  {
		String driverType = PropertyFileLoader.getConfigInstance().getConfigValue("browser");
		switch (driverType) {

		case "chrome":
			if (driver == null || driver.toString().contains("(null)")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			break;

		case "firefox":
			if (driver == null || driver.toString().contains("(null)")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			break;
			
		default:
			break;
		}
		
		return driver;
	}

	public static void closeDriver() {
		try {
			if (driver != null)
				driver.quit();
		} catch (Exception e) {
			System.out.println("Either Driver is not initialized or closed before" + e.getMessage());
		}
	}
	
	

}
