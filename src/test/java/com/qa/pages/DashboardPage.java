package com.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

public class DashboardPage {

	WebDriver driver;
	Scenario scenario;

	// Page object repo

	@FindBy(xpath = "//p[text()='Time at Work']")

	WebElement timeatrworkWidgetTitle;

	// Page object repository

	@FindBy(xpath = "//div[@class='orangehrm-attendance-card-profile-record']/child::p[1]")
	WebElement punchinTime;

	@FindBy(xpath = "//span[text()=' Today']/child::b[1]")
	WebElement todaysTimeHours;

	@FindBy(xpath = "//span[text()=' Today']/child::b[2]")
	WebElement todaysTimeminutes;

	@FindBy(xpath = "//p[text()='This Week']/following-sibling::p")
	WebElement weekSpanTime;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-attendance-card-fulltime']")
	WebElement totalHoursForweek;

	// page class constructor

	public DashboardPage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	// Page operation methods

	public HashMap<String, String> timeatWorkWidgetData() {
		
		HashMap<String, String> objmapWidgetData = new HashMap<String, String>();
		
		objmapWidgetData.put("timeatrworkWidgetTitle",
				ElementActions.getText(driver, timeatrworkWidgetTitle, scenario));
		objmapWidgetData.put("punchinTime", ElementActions.getText(driver, punchinTime, scenario));
		objmapWidgetData.put("todaysTimeHours", ElementActions.getText(driver, todaysTimeHours, scenario));
		objmapWidgetData.put("todaysTimeminutes", ElementActions.getText(driver, todaysTimeminutes, scenario));
		objmapWidgetData.put("weekSpanTime", ElementActions.getText(driver, weekSpanTime, scenario));
		objmapWidgetData.put("totalHoursForweek", ElementActions.getText(driver, totalHoursForweek, scenario));
		return objmapWidgetData;
	}

}
