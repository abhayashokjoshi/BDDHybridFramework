package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

public class ClaimsPage {

	// page object repo + constructor + operation methods

	WebDriver driver;
	Scenario scenario;

	// page object repo

	@FindBy(xpath = "//span[text()='Claim']")
	WebElement claimsPageLink;

	@FindBy(xpath = "//span[text()='Configuration ']")
	WebElement configurationMenu;

	@FindBy(xpath = "//a[text()='Events']")
	WebElement evenetOption;

	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addbutton;

	@FindBy(xpath = "//label[text()='Event Name']/following::input[1]")
	WebElement evenetNameField;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveButton;

	@FindBy(xpath = "//button[text()=' Search ']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='oxd-table-card']/child::div/child::div[2]/child::div[1]")
	WebElement searchedEvenetNameintable;

	@FindBy(xpath = "//div[@class='oxd-table-cell-actions']/child::button/i[@class='oxd-icon bi-pencil-fill']")
	WebElement editeventButton;

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	WebElement deleteeventButton;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement deleteConfirmButton;

	// page class constructor

	public ClaimsPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);

	}

	// page operation methods

	/**
	 * method to navigate to claims page
	 */
	public void navigateToClaimsPage() {
		ElementActions.clickElement(driver, claimsPageLink, scenario);
		WaitMethods.staticWait(5000);
	}

	/**
	 * method to navigate to event page
	 */
	public void navigateToAddevenetsPage() {
		ElementActions.clickElement(driver, configurationMenu, scenario);
		ElementActions.clickElement(driver, evenetOption, scenario);
	}

	/**
	 * @param eventName
	 * method to add new event
	 */
	public void addnewEvenet(String eventName) {

		ElementActions.clickElement(driver, addbutton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, evenetNameField, scenario, eventName);
		ElementActions.clickElement(driver, saveButton, scenario);
		WaitMethods.staticWait(5000);
	}

	/**
	 * @param eventNameToSearch
	 * @return method will search the added event
	 */
	public String searchnewlyaddedEvent(String eventNameToSearch) {
		ElementActions.sendKeys(driver, evenetNameField, scenario, eventNameToSearch);
		WaitMethods.staticWait(5000);
		ElementActions.clickElement(driver, searchButton, scenario);
		WaitMethods.staticWait(5000);
		return ElementActions.getText(driver, searchedEvenetNameintable, scenario);

	}

	/**
	 * @param texttoAppend
	 * method to edit the event name
	 */
	public void editEvent(String texttoAppend) {
		ElementActions.clickElement(driver, editeventButton, scenario);
		ElementActions.sendKeys(driver, evenetNameField, scenario, texttoAppend);
		ElementActions.clickElement(driver, saveButton, scenario);
	}

	/**
	 * method to delete an event
	 */
	public void deletenewlyAddedEvent() {
		ElementActions.clickElement(driver, deleteeventButton, scenario);
		ElementActions.clickElement(driver, deleteConfirmButton, scenario);
	}

}