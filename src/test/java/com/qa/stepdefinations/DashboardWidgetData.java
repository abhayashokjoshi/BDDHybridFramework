package com.qa.stepdefinations;

import com.qa.base.Base;
import com.qa.pages.BuzzPage;
import com.qa.pages.DashboardPage;
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

public class DashboardWidgetData extends Base {

	Scenario scenario;
	LoginPage objLoginPage;
	DashboardPage objDashboardPage;

	@Before
	public void logintoApplication(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^I log in with Admin user and I am at Dashboard Page$")

	public void i_log_in_with_Admin_user_and_I_am_at_Dashboard_Page() throws Throwable {

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
		objDashboardPage = new DashboardPage(driver, scenario);

	}

	@When("^I view the Time at work widget at Dashboard Page$")
	public void i_view_the_Time_at_work_widget_at_Dashboard_Page() throws Throwable {
		scenario.write("In the next step i verify title of time at work widget");

	}

	@Then("^I check below values from the widget showing correct values$")

	public void i_check_below_values_from_the_widget_showing_correct_values(DataTable timeatWorkWidgetDataTable)
			throws Throwable
	{
		scenario.write("I check below values from the widget showing correct values");
		scenario.write("Map Values from the page===== " + objDashboardPage.timeatWorkWidgetData());
		Assert.assertEquals(timeatWorkWidgetDataTable.raw().get(1).get(1),
				objDashboardPage.timeatWorkWidgetData().get("timeatrworkWidgetTitle"));
		Assert.assertEquals(timeatWorkWidgetDataTable.raw().get(2).get(1),
				objDashboardPage.timeatWorkWidgetData().get("punchinTime"));
		Assert.assertEquals(timeatWorkWidgetDataTable.raw().get(3).get(1),
				objDashboardPage.timeatWorkWidgetData().get("todaysTimeHours") + " "
						+ objDashboardPage.timeatWorkWidgetData().get("todaysTimeminutes"));
		Assert.assertEquals(timeatWorkWidgetDataTable.raw().get(4).get(1),
				objDashboardPage.timeatWorkWidgetData().get("weekSpanTime"));
		Assert.assertEquals(timeatWorkWidgetDataTable.raw().get(5).get(1),
				objDashboardPage.timeatWorkWidgetData().get("totalHoursForweek"));
	}

	@After
	public void closeApplication(Scenario scenario) {
		scenario.write("Closing the application");
		closeBrowser();
	}
}
