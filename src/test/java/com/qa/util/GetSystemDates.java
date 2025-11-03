package com.qa.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetSystemDates {

	public static String gettodaysDateinymdFormat() {

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Define the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Format the date
		String formattedtodaysDate = currentDate.format(formatter);

		// Print the formatted date
		return formattedtodaysDate;

	}
}
