package com.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

public class RecruitmentPage {

	WebDriver driver;
	Scenario scenario;

	// Page object repository

	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentpagelink;

	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addcandidateButton;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleNameField;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastNameField;

	@FindBy(xpath = "//label[text()='Email']/following::input[1]")
	WebElement emailInputField;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div/child::div[3]/child::div[1]")
	WebElement searchedCandidateName;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div/child::div[5]/child::div[1]")
	WebElement dateOfcandidateAdded;

	@FindBy(xpath = "//div[@class='oxd-table-cell-actions']/child::button/i[@class='oxd-icon bi-trash']")
	WebElement deleteSearchedcand;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement deleteConfirmButton;

	// Page class constructor
	public RecruitmentPage(WebDriver driver, Scenario scenario) 
	{
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	// Page operation methods
	/**
	 * @return Method used for navigate to Recruitment Page from menu's
	 */
	
	public void navigateToRecruitmentPage() {

		ElementActions.clickElement(driver, recruitmentpagelink, scenario);
	}
	
	/**
	 * Method for adding new candidate
	 * @param fName
	 * @param mName
	 * @param lName
	 * @param email
	 */
	public void addnewCandidate(String fName, String mName, String lName, String email) 
	{
		ElementActions.clickElement(driver, addcandidateButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, firstNameField, scenario, fName);
		ElementActions.sendKeys(driver, middleNameField, scenario, mName);
		ElementActions.sendKeys(driver, lastNameField, scenario, lName);
		ElementActions.sendKeys(driver, emailInputField, scenario, email);
		ElementActions.clickElement(driver, saveButton, scenario);
		WaitMethods.staticWait(5000);
	}
	
	/**
	 * @return
	 * Method to Get Full Name and Candidate creation Date
	 */
	public HashMap<String, String> getfullNameandCandidateCreationDate() 
	{
		navigateToRecruitmentPage();
		WaitMethods.staticWait(5000);
		HashMap<String, String> nameandDateMap = new HashMap<String, String>();
		nameandDateMap.put("fullName", ElementActions.getText(driver, searchedCandidateName, scenario));
		nameandDateMap.put("candidatecreationDate", ElementActions.getText(driver, dateOfcandidateAdded, scenario));
		return nameandDateMap;
	}
	
	/**
	 * Method to Delete the Added Candidate
	 */
	public void deleteCandidate() 
	{
		ElementActions.clickElement(driver, deleteSearchedcand, scenario);
		ElementActions.clickElement(driver, deleteConfirmButton, scenario);
	}
	
}
