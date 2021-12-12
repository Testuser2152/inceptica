package com.inceptica.hooks;

import com.inceptica.driverManager.TestBase;
import com.inceptica.testUtils.SeleniumHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void Before(Scenario scenario)  {
		SeleniumHelper.setScenario(scenario);

		System.out.println("**********************************************");
		System.out.println(" Started Working on Scenario : " + scenario.getName());
		System.out.println("**********************************************");
		
	}

	@After
	public void After(Scenario scenario)  {
		SeleniumHelper.setScenario(scenario);

		
	System.out.println("**********************************************");
		System.out.println(" Completed Working on Scenario : " + scenario.getName());
		System.out.println("**********************************************");
		
		TestBase.closeDriver();
	}

}
