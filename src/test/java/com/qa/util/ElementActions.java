package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.Scenario;

/**
 * @author Abhay
 * This class has all Selenium web element methods with wait mechanism applied
 * with the exception handling.
 *
 */
public class ElementActions {

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @param textotype
	 *            This method will accept the text to type and wait for fluent
	 *            wait time until element i click-able and then type text
	 *
	 */
	public static void sendKeys(WebDriver driver, WebElement elem, Scenario scenario, String texttoType) {
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Element ");
		}
		try {
			elem.sendKeys(texttoType);
		} catch (Exception E) {
			scenario.write(" Error on typing the text in element after waiting !");
		}
	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @return This method will wait for fluent wait time and when element is
	 *         visible get the text and return the String value.
	 */
	public static String getText(WebDriver driver, WebElement elem, Scenario scenario) {

		String texttoReturn = null;
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_VISIBLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for Element visibility  ");
		}
		try {
			texttoReturn = elem.getText();
		} catch (Exception E) {
			scenario.write(" Error on fetching  the text in element after waiting !");
		}
		return texttoReturn;
	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @param option
	 * @return This method will accept option as parameter and select the value
	 *         from the drop-down.
	 */
	public static void selectOptionFromDropDown(WebDriver driver, WebElement elem, Scenario scenario, String option) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for Element to be clickable  ");
		}

		Select objselect = new Select(elem);

		try {
			objselect.selectByValue(option);
		} catch (Exception E) {
			scenario.write(" Error while selecting the option from Dropdown! ");
		}
	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 *            This method will take element as parameter and wait for
	 *            explicit wait time And then perform click operation
	 */
	public static void clickElement(WebDriver driver, WebElement elem, Scenario scenario) {
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Element ");
		}

		try {
			elem.click();
		} catch (Exception E) {
			scenario.write(" Error on clicking the element after waiting !");
		}
	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 *            This method will clear the existing value from the field
	 */
	public static void clearFieldvalue(WebDriver driver, WebElement elem, Scenario scenario) {
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Element ");
		}

		try {
			elem.clear();
		} catch (Exception E) {
			scenario.write(" Error on clicking the element after waiting !");
		}
	}

}
