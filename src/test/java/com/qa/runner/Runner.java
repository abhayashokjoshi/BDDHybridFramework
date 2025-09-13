package com.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features", glue = { "com.qa.stepdefinations" }, tags = {

		"@executeallfromJenkins" }, plugin = { "pretty", "html:target/cucumber-reports" }, monochrome = true)

public class Runner {

}
