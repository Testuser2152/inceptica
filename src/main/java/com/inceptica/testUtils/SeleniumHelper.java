package com.inceptica.testUtils;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.inceptica.driverManager.TestBase;

import cucumber.api.Scenario;

/**
 * @author This class methods are used to Perform operations in
 *         WebApplication
 */
public class SeleniumHelper {

	private static final Logger logger = Logger.getLogger(SeleniumHelper.class);
	WebDriver driver;

	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
	}
	
	protected void cleanup() {
		TestBase.closeDriver();
	}

	protected WebDriver getDriver() {
		return TestBase.getDriver();
	}

	public static void setScenario(Scenario scenario) {
	}
	
	public boolean isEnabled(WebElement element) {
		boolean temp = false;
		try {
			if (element.isEnabled()) {
				temp = true;
				return temp;
			}
		} catch (Exception e) {
			raiseException();
		}
		return temp;
	}
	
	protected boolean isExists(WebElement element) {

		boolean eleExists = false;
		try {
			if (element.getText() != null) {
				eleExists = true;
				logger.info("element is present");
			}
		} catch (NoSuchElementException e) {
			logger.error("element is not present");
			raiseException();
		}
		return eleExists;

	}
	
	protected void enterText(WebElement element, String strText, String description) {
		logger.info("Into enterText by using input text " + strText + " and locator element :" + element.toString());
		try {
			WebDriverWait wait = new WebDriverWait(driver, PropertyFileLoader.getConfigInstance().getWebDriverWait());

			if (isExists(element)) {
				if (isEnabled(element)) {
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					element.clear();
					element.sendKeys(strText);
					logger.info("Enter text: " + strText);
				}
			}
		} catch (Exception e) {
			logger.error("Exception generated while working with enterText by using input text " + strText
					+ " and locator element :" + element.toString());
			raiseException();
		}
	}

	protected void click(WebElement element, String description) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, PropertyFileLoader.getConfigInstance().getWebDriverWait());
			if (isExists(element)) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				logger.info(description + " is clicked");
			} else {
				logger.info(description + " is NOT clicked");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			raiseException();
		}
	}

	protected void pause() {

		try {
			Thread.sleep(PropertyFileLoader.getConfigInstance().getPause());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			raiseException();
		}
	}

	protected void raiseException() {

		takeScreenShot();
		cleanup();
		Assert.assertTrue(false);
	}

	protected void raiseException(String assertionMsg) {

		takeScreenShot();
		Assert.assertTrue(assertionMsg, false);

	}

	protected void takeScreenShot() {
		try {
			Random rand = SecureRandom.getInstanceStrong();
			// This takes a screenshot from the driver at save it to the specified location
			String screenshotName = "screenshotName";
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			logger.info("target screenshot : " + (System.getProperty("user.dir")
					+ "/target/cucumber-reports/screenshots/" + screenshotName + "_" + rand.nextInt(10000) + ".png"));
			File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
					+ screenshotName + "_" + rand.nextInt(10000) + ".png");

			destinationPath.getParentFile().mkdirs();
			destinationPath.createNewFile();
			Files.copy(sourcePath, destinationPath);
			logger.info("before reporter screenshot : " + destinationPath + "," + sourcePath);
			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException:: " + e.getMessage());
		} catch (IOException e) {
			logger.error("IOException:: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception:: " + e.getMessage());
		}

	}

	public void waitForPageLoad() {

		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, PropertyFileLoader.getConfigInstance().getWebDriverWait());
		wait.until(pageLoadCondition);
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			pause();
			System.out.println();
		} catch (Exception e) {

		}
	}
	
	public String getCurrentPageURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void clickWithJavaScriptExecutor(WebElement element, String description) {
		try {
			if (isExists(element)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
				logger.info(description + " is clicked");
			} else {
				logger.info(description + " is NOT clicked");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			raiseException();
		}

	}

	public void assertData(String expectedVal, String actualVal) {
		try {
			Assert.assertEquals(expectedVal, actualVal);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			raiseException();
		}
	}
}