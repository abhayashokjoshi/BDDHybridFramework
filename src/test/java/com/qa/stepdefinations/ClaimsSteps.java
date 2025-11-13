package com.qa.stepdefinations;

import com.qa.base.Base;
import com.qa.pages.ClaimsPage;
import com.qa.pages.LoginPage;
import com.qa.util.CaptureScreenshot;
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

public class ClaimsSteps extends Base {

	Scenario scenario;
	LoginPage objLoginPage;
	ClaimsPage objClaimsPage;

	@Before
	public void logintoApplication(Scenario scenario) {

		this.scenario = scenario;
	}

	@Given("^Navigate to Claims after log in with Admin user$")
	public void navigate_to_Claims_after_log_in_with_Admin_user() throws Throwable {
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

		scenario.write("Navigating to Claim Page");

		objClaimsPage = new ClaimsPage(driver, scenario);
		objClaimsPage.navigateToClaimsPage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^I navigate to Configuration menu and Select Event option$")
	public void i_navigate_to_Configuration_menu_and_Select_Event_option() throws Throwable {
		scenario.write("Navigating to event Page");

		objClaimsPage.navigateToAddevenetsPage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^I add new Event with below event Name$")
	public void i_add_new_Event_with_below_event_Name(DataTable eventnameTable) throws Throwable {
		scenario.write("Adding new Event");
		objClaimsPage.addnewEvenet(eventnameTable.raw().get(0).get(1));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I Search Event with below eventName$")
	public void i_Search_Event_with_below_eventName(DataTable SearcEveneTable) throws Throwable {
		scenario.write("Searching  new Event");
		Assert.assertEquals(SearcEveneTable.raw().get(0).get(1),
				objClaimsPage.searchnewlyaddedEvent(SearcEveneTable.raw().get(0).get(1)));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^I edit the Event and change name$")
	public void i_edit_the_Event_and_change_name(DataTable appendtexttoeventname) throws Throwable {
		scenario.write("Editing  new Event");
		objClaimsPage.editEvent(appendtexttoeventname.raw().get(0).get(1));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I delete the newly added and updated Event$")
	public void i_delete_the_newly_added_and_updated_Event() throws Throwable {
		objClaimsPage.deletenewlyAddedEvent();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	// Add Expenses Steps

	@Given("^I navigate to submit claims Page$")
	public void i_navigate_to_submit_claims_Page() throws Throwable {

		scenario.write("navigating to submitclaims");
		objClaimsPage.submitClaims();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^I crate claim Request with Event and Currency$")
	public void i_crate_claim_Request_with_Event_and_Currency(DataTable eventandCurrencytbl) throws Throwable {
		scenario.write("SelectingEvent aned currency");
		objClaimsPage.selecteventandcurrency();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^I add Expenses for the new claim Request with below fields and values$")
	public void i_add_Expenses_for_the_new_claim_Request_with_below_fields_and_values(DataTable expDateandAmountTable)
			throws Throwable {
		scenario.write("Adding expenses in below step!");
		objClaimsPage.addExpense(expDateandAmountTable.raw().get(2).get(1), expDateandAmountTable.raw().get(3).get(1));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I verify the total amount of all expenses is caculated correctly$")
	public void i_verify_the_total_amount_of_all_expenses_is_caculated_correctly() throws Throwable {
		Assert.assertEquals("100.00", objClaimsPage.getTotalAmount().trim());
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@After
	public void closeApplication(Scenario scenario) {
		scenario.write("Closing the application");
		closeBrowser();
	}

}