package com.qa.stepdefinations;

import org.junit.Assert;

import com.qa.base.Base;
import com.qa.pages.BuzzPage;
import com.qa.pages.LoginPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.ReadProperties;
import com.qa.util.WaitMethods;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuzzCRUDSteps extends Base {
	Scenario scenario;
	LoginPage objLoginPage;
    BuzzPage objBuzzPage;

	@Before
	public void logintoApplication(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^Navigate to Buzz after log in with Admin user$")
	public void navigate_to_Buzz_after_log_in_with_Admin_user() throws Throwable 
	{
		scenario.write("Starting the Orange HRM application in browser");
		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

		scenario.write("Logging in to Orange HRMS Application");
		objLoginPage = new LoginPage(driver, scenario);
		String actualHomePageTitle = objLoginPage.logintoApplication(ReadProperties.getAppUserName(),
				ReadProperties.getAppPassword());
		Assert.assertEquals("Dashboard", actualHomePageTitle);
		;
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		
		scenario.write("Navigating to Buzz Page");
		objBuzzPage = new BuzzPage(driver, scenario);
		objBuzzPage.navigateToBuzzPage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		
	}

	@When("^Post the comment as \"([^\"]*)\"$")
	public void post_the_comment_as(String commentToPost) throws Throwable 
	{
		scenario.write("Posting the comment ");
		objBuzzPage.addPost(commentToPost);
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		
	}

	@Then("^verify that comment time user and comment text is posted correctly as \"([^\"]*)\"$")
	public void verify_that_comment_time_user_and_comment_text_is_posted_correctly_as(String extectedText) throws Throwable 
	{
		scenario.write("verifying Posted  comment ");
		Assert.assertEquals(extectedText, objBuzzPage.getPostedTexttoVerify());
	}

	@When("^I click on like$")
	public void i_click_on_like() throws Throwable 
	{
		scenario.write("Doing like for post");
		objBuzzPage.clickLikeButton();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I verify the like count is updated as Expected count \"([^\"]*)\"$")
	public void i_verify_the_like_count_is_updated_as_Expected_count(String expectedCount) throws Throwable 
	{
		Assert.assertEquals(Integer.parseInt(expectedCount), Integer.parseInt(objBuzzPage.likeCount()));
	}

	@When("^I Edit the post with updated comment\"([^\"]*)\"$")
	public void i_Edit_the_post_with_updated_comment(String updatedCommentText) throws Throwable 
	{
		scenario.write("Editing the post");
		objBuzzPage.EditPost(updatedCommentText);
	}

	@Then("^I verify that updated comment\"([^\"]*)\"$") 
	public void i_verify_that_updated_comment(String updatedCommentText) throws Throwable 
	{
		scenario.write("Verifying updated post containes the appended text ");
		Assert.assertTrue(objBuzzPage.getPostedTexttoVerify().contains(updatedCommentText));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I delete the Post$")
	public void i_delete_the_Post() throws Throwable 
	{
		scenario.write("Deleting the post");
		objBuzzPage.deletePost();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@After
	public void closeApplication(Scenario scenario) 
	{
		scenario.write("Closing the application");
		closeBrowser();
	}

}
