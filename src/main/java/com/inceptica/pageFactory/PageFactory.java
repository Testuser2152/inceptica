package com.inceptica.pageFactory;

import org.openqa.selenium.WebDriver;

import com.inceptica.pages.JobSearchPage;

/**
 * @author Sandeep
 * @param <CalculatorApp>
 * @description We use PageFactory for Page Factory pattern to initialize
 *              WebElements which are defined in Page Objects
 */

public class PageFactory {

	private WebDriver driver;
	private JobSearchPage jobSearchPage;
	

	/***
	 * Constructor
	 * @param driver an instance of WebDriver
	 */

	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * @description Create object of JobSearchPage Class
	 * @return Instantiate the JobSearchPage Class
	 */

	public JobSearchPage getJobSearchPage() {
		return (jobSearchPage == null) ? jobSearchPage = new JobSearchPage(driver) : jobSearchPage;
	}



}
