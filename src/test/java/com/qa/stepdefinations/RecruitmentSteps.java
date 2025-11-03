package com.qa.stepdefinations;

import com.qa.base.Base;
import com.qa.pages.LoginPage;
import com.qa.pages.RecruitmentPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.GetSystemDates;
import com.qa.util.ReadProperties;
import com.qa.util.WaitMethods;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class RecruitmentSteps extends Base {

	Scenario scenario;
	LoginPage objLoginPage;
	public String empFullName;
	RecruitmentPage objRecruitmentPage;

	@Before
	public void logintoApplication(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^Navigate to Recruitment page after log in with Admin$")

	public void navigate_to_Recruitment_page_after_log_in_with_Admin() throws Throwable {
		scenario.write("Starting the Orange HRM application in browser");
		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("Logging in to Orange HRMS APplication");
		objLoginPage = new LoginPage(driver, scenario);
		String actualHomePageTitle = objLoginPage.logintoApplication(ReadProperties.getAppUserName(),
				ReadProperties.getAppPassword());
		Assert.assertEquals("Dashboard", actualHomePageTitle);
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("NavigatingtoRecruitmentPage");
		objRecruitmentPage = new RecruitmentPage(driver, scenario);
		objRecruitmentPage.navigateToRecruitmentPage();
		WaitMethods.staticWait(2000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^Add new Candidate with below field and values$")
	public void add_new_Candidate_with_below_field_and_values(DataTable candidateinfoTable) throws Throwable {
		objRecruitmentPage.addnewCandidate(candidateinfoTable.raw().get(1).get(1),
		candidateinfoTable.raw().get(2).get(1), candidateinfoTable.raw().get(3).get(1),
		candidateinfoTable.raw().get(4).get(1));
		empFullName = candidateinfoTable.raw().get(1).get(1) + " " + candidateinfoTable.raw().get(2).get(1) + " "
		+ candidateinfoTable.raw().get(3).get(1);
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I verify that candidate is added with currentDate$")
	public void i_verify_that_candidate_is_added_with_currentDate() throws Throwable {
		scenario.write("Verifying Candidate name and date");
		Assert.assertEquals(empFullName, objRecruitmentPage.getfullNameandCandidateCreationDate().get("fullName"));
		Assert.assertEquals(GetSystemDates.gettodaysDateinymdFormat(),
		objRecruitmentPage.getfullNameandCandidateCreationDate().get("candidatecreationDate"));
	}

	@Then("^I delete the searched Candidate$")
	public void i_delete_the_searched_Candidate() throws Throwable {
		scenario.write("Deleting the candidate");
		objRecruitmentPage.deleteCandidate();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@After
	public void closeApplication(Scenario scenario) {
		scenario.write("Closing the application");
		closeBrowser();
	}

}
