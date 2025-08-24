package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Abhay This class has common methods to read properties from
 *         config.properties file
 * 
 */

public class ReadProperties {

	/**
	 * @author Abhay This method will read properties and load properties and
	 *         return the object.
	 */

	public static Properties loadProperties() {

		// Open the File

		File objfile = new File("AppConfig/config.properties");

		// Read the File

		FileInputStream objfis = null;

		try {

			objfis = new FileInputStream(objfile);

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

		}

		Properties objprop = new Properties();

		try {

			objprop.load(objfis);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return objprop;
	}

	public static String getappURL() {
		/**
		 * @author Abhay This method will read property of appURL from config file
		 *        
		 */
		return loadProperties().getProperty("appURL");
	}

	public static long implicitWaitTime() {

		/**
		 * @author Abhay This method will read property of implicitWait from config file
		 *        
		 */
		return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));
	}

	public static String getAppUserName() {

		/**
		 * @author Abhay This method will read property of AppUserName from config file
		 *        
		 */
		return loadProperties().getProperty("userName");
	}

	public static String getAppPassword() {
		
		/**
		 * @author Abhay This method will read property of AppPassword from config file
		 *        
		 */
		return loadProperties().getProperty("password");
	}

	public static long getFluentWaitTime() {

		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));
	}

}
