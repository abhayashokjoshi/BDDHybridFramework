package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

/**
 * @author Abhay This class has page factory code for PIM page
 *
 */
public class AddEmployeePage {
	WebDriver driver;
	Scenario scenario;

	// Page object repo

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

	// page repo for search emp

	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement empListPageLink;  

	@FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
	WebElement searchByEmpNamefield;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement empSearchButton;

	@FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/child::div[3]/child::div[1]")
	WebElement searchedEmpFandMname;

	// page repo for edit emp

	@FindBy(xpath = "//div[@class='oxd-table-cell-actions']/child::button/i[@class='oxd-icon bi-pencil-fill']")
	WebElement editEmpButton;

	@FindBy(xpath = "//label[text()='Employee Full Name']/following::input[@name='firstName']")
	WebElement empfirstName;

	@FindBy(xpath = "//label[text()='Employee Full Name']/following::input[@name='middleName']")
	WebElement empmiddleName;

	@FindBy(xpath = "//label[text()='Employee Full Name']/following::input[@name='lastName']")
	WebElement emplastName;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement editandSaveButton;

	// page repo for delete emp

	@FindBy(xpath = "//div[@class='oxd-table-cell-actions']/child::button/i[@class='oxd-icon bi-trash']")
	WebElement deleteSearchedEmp;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement deleteConfirmButton;

	@FindBy(xpath = "//span[text()='No Records Found']")
	WebElement noRecordFoundTextAfterDelete;

	// page class constructor
	/**
	 * @param driver
	 * @param scenario
	 */
	public AddEmployeePage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	// page operation methods
	/**
	 * 
	 */
	public void navigateToPimPage() {
		ElementActions.clickElement(driver, pimPageLink, scenario);
	}

	/**
	 * @param fName
	 * @param mName
	 * @param lName
	 *            This method will add new employee and save it
	 * @throws InterruptedException
	 */
	public void addnewEmployee(String fName, String mName, String lName) throws InterruptedException {

		ElementActions.clickElement(driver, addEmpButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, firstNameField, scenario, fName);
		ElementActions.sendKeys(driver, middleNameField, scenario, mName);
		ElementActions.sendKeys(driver, lastNameField, scenario, lName);
		ElementActions.clickElement(driver, saveButton, scenario);

	}

	/**
	 * 
	 */
	public void navigateToEmpListPage() {
		ElementActions.clickElement(driver, empListPageLink, scenario);
	}

	/**
	 * @param fName
	 * @param mName
	 * @return This method will search the existing employee details
	 */
	public String searchEmp(String fName, String mName) {
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, searchByEmpNamefield, scenario, fName + " " + mName);
		WaitMethods.staticWait(2000);
		Actions objactions = new Actions(driver);
		objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, empSearchButton, scenario);
		return ElementActions.getText(driver, searchedEmpFandMname, scenario);
	}

	/**
	 * @param fnameupendtext
	 * @param mNameupendtext
	 * @param lNameupendtext
	 *            This method will edit the employee details and save it
	 */
	public void editEmp(String fnameupendtext, String mNameupendtext, String lNameupendtext) {

		ElementActions.clickElement(driver, editEmpButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, empfirstName, scenario, fnameupendtext);
		ElementActions.sendKeys(driver, empmiddleName, scenario, mNameupendtext);
		ElementActions.sendKeys(driver, emplastName, scenario, lNameupendtext);
		WaitMethods.staticWait(5000);
		ElementActions.clickElement(driver, editandSaveButton, scenario);

	}

	/**
	 * @return This method will delete emp details and return "no record found"
	 *         msg
	 */
	public String deleteUdpateEmp() {
		ElementActions.clickElement(driver, deleteSearchedEmp, scenario);
		ElementActions.clickElement(driver, deleteConfirmButton, scenario);
		WaitMethods.staticWait(5000);
		return ElementActions.getText(driver, noRecordFoundTextAfterDelete, scenario);
	}
}