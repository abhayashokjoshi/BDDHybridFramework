package com.qa.stepdefinations;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeCRUD {

	@Given("^Navigate to PIM after log in with Admin user$")
	public void navigate_to_PIM_after_log_in_with_Admin_user() throws Throwable {

		System.out.println("Selenium Code to be added here!");

	}

	@When("^I Add employee with  first name as \"([^\"]*)\" and mname as \"([^\"]*)\" and lName as \"([^\"]*)\"$")
	public void i_Add_employee_with_first_name_as_and_mname_as_and_lName_as(String arg1, String arg2, String arg3)
			throws Throwable {

		System.out.println("Selenium Code to be added here!");

	}

	@Then("^I  verify employeeAdded in list with  first name as \"([^\"]*)\" and mname as \"([^\"]*)\" and lName as \"([^\"]*)\"$")
	public void i_verify_employeeAdded_in_list_with_first_name_as_and_mname_as_and_lName_as(String arg1, String arg2,
			String arg3) throws Throwable {

		System.out.println("Selenium Code to be added here!");

	}

	@When("^I click on Edit button and update below values and save the Data$")
	public void i_click_on_Edit_button_and_update_below_values_and_save_the_Data(DataTable arg1) throws Throwable {

		System.out.println("Selenium Code to be added here!");

	}

	@Then("^I search the employee and ensure that it is searched using below values$")
	public void i_search_the_employee_and_ensure_that_it_is_searched_using_below_values(DataTable arg1)
			throws Throwable {

		System.out.println("Selenium Code to be added here!");

	}

	@Then("^I select and Delete the Updated Employee and verify employee is not  in search result$")
	public void i_select_and_Delete_the_Updated_Employee_and_verify_employee_is_not_in_search_result()
			throws Throwable {

		System.out.println("Selenium Code to be added here!");

	}

}
