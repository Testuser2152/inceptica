package com.inceptica.stepDefination;

import org.openqa.selenium.WebDriver;

import com.inceptica.driverManager.TestBase;
import com.inceptica.pageFactory.PageFactory;
import com.inceptica.pages.JobSearchPage;
import com.inceptica.testUtils.PropertyFileLoader;
import com.inceptica.testUtils.SeleniumHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	WebDriver driver = TestBase.getDriver();
	PageFactory pagefactory = new PageFactory(driver);
	SeleniumHelper seleniumHelper = new SeleniumHelper(driver);
	JobSearchPage jobSearchPage = pagefactory.getJobSearchPage();


	@Given("^User is on Cv libraray site$")
    public void user_is_on_cv_libraray_site()  {
		driver.get(PropertyFileLoader.getConfigInstance().getqaURL());
    }

    @When("^User provides the Job details$")
    public void user_provides_the_job_details()  {
        
    	jobSearchPage.enterJobTitle(PropertyFileLoader.getConfigInstance().getConfigValue("jobSearch_jobTitle"));
    	jobSearchPage.enterLocation(PropertyFileLoader.getConfigInstance().getConfigValue("jobSearch_location"));
    	
    	jobSearchPage.clickOnDistanceDropdown();
    	jobSearchPage.selectDistanceFromList(PropertyFileLoader.getConfigInstance().getConfigValue("jobSearch_distance"));
    	
    	jobSearchPage.clickOnMoreSearchLink();
    	
    	jobSearchPage.enterMinSalary(PropertyFileLoader.getConfigInstance().getConfigValue("jobSearch_minSalary"));
    	jobSearchPage.enterMaxSalary(PropertyFileLoader.getConfigInstance().getConfigValue("jobSearch_maxSalary"));
    	
    	jobSearchPage.clickOnSalaryTypeDropdown();
    	jobSearchPage.selectSalaryTypeFromList(PropertyFileLoader.getConfigInstance().getConfigValue("jobSearch_salaryType"));
    	
    	jobSearchPage.clickOnJobTypeDropdown();
    	jobSearchPage.selectJobTypeFromList(PropertyFileLoader.getConfigInstance().getConfigValue("jobSearch_jobType"));
    }

    @Then("^Click on FindJobs$")
    public void click_on_findjobs()  {
    	
    	jobSearchPage.clickOnFindJobsBtn();
    }


}
