package com.inceptica.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resource\\features" }, 
		glue = { "com.inceptica.stepDefination","com.inceptica.hooks" }, 
		plugin = { "pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html",
				"html:target/html_Reports", "json:target/results.json",},
		dryRun = false,
		tags = { "@jobSearch" }, monochrome = true)

public class TestRunner {

}

