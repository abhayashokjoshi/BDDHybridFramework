package com.qa.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

// @CucumberOptions(features = "src/test/resources/features", glue = {
// "com.qa.stepdefinations" }, tags = {"@executeallfromJenkins" }, plugin = { "pretty",
// "html:target/cucumber-reports" }, monochrome = true)

@CucumberOptions(features = "src/test/resources/features", glue = "com.qa.stepdefinations", tags = {"@BuzzCRUDTest"}, plugin = { "pretty", "json:target/cucumber-report.json",
		"json:target/cucumber-reports/Cucumber.json" }, monochrome = true ) 

//json:target/cucumber-reports/Cucumber.json
//local working code line : //junit:target/cucumber-report.xml

public class Runner {

}
