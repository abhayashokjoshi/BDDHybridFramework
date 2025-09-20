package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

/**
 * @author Abhay This class contains page object of Add Employee
 *
 */
public class AddEmployeePage {

	WebDriver driver;
	Scenario scenario;

	// Page objects repository

	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pimPageLink;

	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addEmpButton;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleNameField;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastNameField;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveButton;

	// Page class constructor
	public AddEmployeePage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	// Navigate to PIN Page
	/**
	 * Navigating to PIM Page
	 */
	public void navigateToPimPage() 
	{
		ElementActions.clickElement(driver, pimPageLink, scenario);
	}

	/**
	 * @param fName
	 * @param mName
	 * @param lName
	 */
	public void addnewEmployee(String fName, String mName, String lName) 
	{
		ElementActions.clickElement(driver, addEmpButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, firstNameField, scenario, fName);
		ElementActions.sendKeys(driver, middleNameField, scenario, mName);
		ElementActions.sendKeys(driver, lastNameField, scenario, lName);
		ElementActions.clickElement(driver, saveButton, scenario);
	}
}
