package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

public class LeavePage {

	WebDriver driver;
	Scenario scenario;

	// Page object repository
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leavePage;

	@FindBy(xpath = "//span[text()='Configure ']")
	WebElement configureMenu;

	@FindBy(xpath = "//a[text()='Leave Types']")
	WebElement leaveTypeOption;

	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addLeaveTypeButton;

	@FindBy(xpath = "//h6[text()='Add Leave Type']/following::input[1]")
	WebElement addLeaveTypeTextField;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveBUtton;

	@FindBy(xpath = "//div[@class='oxd-table-card']/child::div/child::div[2]/child::div")
	WebElement newlyaddedLeaveTypeText;

	@FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
	WebElement leavetypeEditbutton;

	@FindBy(xpath = "//h6[text()='Edit Leave Type']/following::input[1]")
	WebElement editleaveTypeField;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement editandsaveButton;

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	WebElement deleteLEaveTypeButton;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement deleteConfirmButton;

	// Page class constructor

	public LeavePage(WebDriver driver, Scenario scenario) 
	{
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	// Page operation methods
	
	/**
	 * Method used to navigate to leave page
	 */
	public void navigateToLeavePage() 
	{
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, leavePage, scenario);
		WaitMethods.staticWait(2000);
	}

	/**
	 * Method used to navigate to leave type
	 */
	public void navigateToLeaveTypePage() 
	{
		ElementActions.clickElement(driver, configureMenu, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.clickElement(driver, leaveTypeOption, scenario);
		WaitMethods.staticWait(5000);
	}
	
	/**
	 * @param leaveTypetext
	 * Method used to add new leave type text into text field
	 */
	public void addnewLeaveType(String leaveTypetext) 
	{
		ElementActions.clickElement(driver, addLeaveTypeButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, addLeaveTypeTextField, scenario, leaveTypetext);
		ElementActions.clickElement(driver, saveBUtton, scenario);
		WaitMethods.staticWait(5000);
	}

	/**
	 * @return
	 * Method used to get newly added leave type
	 */
	public String getnewlyaddedLeaveType() 
	{
		return ElementActions.getText(driver, newlyaddedLeaveTypeText, scenario);
	}
	
	/**
	 * @param texttoAppend
	 * Method used to edit the recently added leave type with new text
	 */
	public void editLeaveType(String texttoAppend) 
	{
		ElementActions.clickElement(driver, leavetypeEditbutton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, editleaveTypeField, scenario, texttoAppend);
		ElementActions.clickElement(driver, editandsaveButton, scenario);
		WaitMethods.staticWait(5000);
	}

	/**
	 * Method to delete the added leave type
	 */
	public void deleteLEaveType() 
	{
		ElementActions.clickElement(driver, deleteLEaveTypeButton, scenario);
		ElementActions.clickElement(driver, deleteConfirmButton, scenario);
	}
}
