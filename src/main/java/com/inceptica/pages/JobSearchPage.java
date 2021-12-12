package com.inceptica.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inceptica.testUtils.SeleniumHelper;

/**
 * @author Sandeep
 * @description JobSearchPage Locators and Methods
 */
public class JobSearchPage extends SeleniumHelper {

	
	WebDriverWait wait;

	public JobSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@name='q'])[2]")
	private WebElement jobTitle;
	
	@FindBy(xpath = "//div[@class='hps-location hps-transition']//input[@name='geo']")
	private WebElement location;
	
	@FindBy(xpath = "//div[@class='hps-distance hps-transition']//select[@name='distance']")
	private WebElement distanceDropdown;
	
	@FindBy(xpath = "//div[@class='hps-distance hps-transition']//select[@name='distance']/option")
	private List<WebElement> distanceList;
	
	@FindBy(xpath = "//div[@class='hp-search-more']//button[@id='toggle-hp-search']")
	private WebElement moreSearchLink;
	
	@FindBy(xpath = "//div[@class='hps-sal-min']//input[@id='salarymin']")
	private WebElement minsalaty;
	
	@FindBy(xpath = "//div[@class='hps-sal-max']//input[@id='salarymax']")
	private WebElement maxSalary;
	
	@FindBy(xpath = "//div[@class='hps-sal-type']//select[@id='salarytype']")
	private WebElement salaryTypeDropdown;
	
	@FindBy(xpath = "//div[@class='hps-sal-type']//select[@id='salarytype']//option")
	private List<WebElement> salaryTypeList;

	@FindBy(xpath = "//div[@class='hps-jobtype']//select[@id='tempperm']")
	private WebElement jobTypeDropdown;
	
	@FindBy(xpath = "//div[@class='hps-jobtype']//select[@id='tempperm']/option")
	private List<WebElement> jobTypeList;
	
	@FindBy(xpath = "//input[@id='hp-search-btn']")
	private WebElement findJobsBtn;
	

	public void enterJobTitle(String JobTitle) {
		System.out.println("Enters JobTitle as : " + JobTitle + " on JobSearch Page");
		enterText(jobTitle, JobTitle, "Enters JobTitle");
	}

	public void enterLocation(String Location) {
		System.out.println("Enters Location as : " + Location + " on JobSearch");
		enterText(location, Location, "Enters Location :");
	}

	public void clickOnDistanceDropdown() {
		System.out.println("Clicking on Distance Dropdown on JobSearch");
		click(distanceDropdown, "Click on Distance Dropdown on JobSearch");
	}
	
	public void selectDistanceFromList(String distance) {
		System.out.println("select on Distance Dropdown from List");
		for (int i = 0; i < distanceList.size(); i++) {
			if(distanceList.get(i).getText().contains(distance)) {
				distanceList.get(i).click();
				break;
			}
		}
	}
	
	public void clickOnMoreSearchLink() {
		System.out.println("Clicking on More Search Link on JobSearch");
		click(moreSearchLink, "Click on More Search Link on JobSearch");
	}
	
	public void enterMinSalary(String min) {
		System.out.println("Enters Min Salary as : " + min + " on JobSearch");
		enterText(minsalaty, min, "Enters Min Salary :");
	}
	
	public void enterMaxSalary(String max) {
		System.out.println("Enters Min Salary as : " + max + " on JobSearch");
		enterText(maxSalary, max, "Enters Max Salary :");
	}
	
	public void clickOnSalaryTypeDropdown() {
		System.out.println("Clicking on SalaryType Dropdown on JobSearch");
		click(salaryTypeDropdown, "Click on SalaryType Dropdown on JobSearch");
	}
	
	public void selectSalaryTypeFromList(String salaryType) {
		System.out.println("select on SalaryType Dropdown from List");
		for (int i = 0; i < salaryTypeList.size(); i++) {
			if(salaryTypeList.get(i).getText().equals(salaryType)) {
				salaryTypeList.get(i).click();
				break;
			}
		}
	}
	
	public void clickOnJobTypeDropdown() {
		System.out.println("Clicking on JobType Dropdown on JobSearch");
		click(jobTypeDropdown, "Click on JobType Dropdown on JobSearch");
	}
	
	public void selectJobTypeFromList(String jobType) {
		System.out.println("select on JobType Dropdown from List");
		for (int i = 0; i < jobTypeList.size(); i++) {
			if(jobTypeList.get(i).getText().equals(jobType)) {
				jobTypeList.get(i).click();
				break;
			}
		}
	}
	
	public void clickOnFindJobsBtn() {
		System.out.println("Clicking on FindJobs button on JobSearch");
		click(findJobsBtn, "Click on FindJobs button on JobSearch");
	}


	
}
