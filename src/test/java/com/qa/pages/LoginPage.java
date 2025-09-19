package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

/**
 * @author Abhay
 * This class has page factory code for Orange HRM Login Page
 *
 */
public class LoginPage {
	
	WebDriver driver;
	Scenario scenario;
	
	//Each page class having 3 things
	//1. Page object repository - Element located by findBy annotation
	//2. Page Class Constructor
	//3. Page Operation Methods
	
	//Page Object Repository

	@FindBy (xpath = "//input[@name='username']")
	WebElement userNameField;
	
	@FindBy (xpath="//input[@name='password']")
	WebElement passwordField;
	
	@FindBy (xpath="//button[text()=' Login ']")
	WebElement loginButton;
	
	@FindBy (xpath = "//h6[text()='Dashboard']")
	WebElement homepageTitle;
	
	//Page Class Constructor
	
	/**
	 * @param driver
	 */
	public LoginPage (WebDriver driver, Scenario scenario)
	{
		this.driver=driver;
		this.scenario=scenario;
		PageFactory.initElements(driver, this);
	}
	
	//Page Operation Methods
	
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 
	 * This method accepts Username and Password as parameter and clicking on login button and return home page text
	 */
	public String logintoApplication(String userName, String userPassword)
	{
		ElementActions.sendKeys(driver, userNameField, scenario, userName);
		ElementActions.sendKeys(driver, passwordField, scenario, userPassword);
		ElementActions.clickElement(driver, loginButton, scenario);
		return ElementActions.getText(driver, homepageTitle, scenario);
	}
}
