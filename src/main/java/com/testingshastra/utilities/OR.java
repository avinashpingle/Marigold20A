package com.testingshastra.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class can be used to read Object Repository file only.
 * @author avinashpingale
 *
 */
public class OR {

	public static String getLocator(String locatorName) {
		String dir = System.getProperty("user.dir");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(dir+"/src/test/resources/ObjectRepository.properties");
		} catch (FileNotFoundException e) {
			System.err.println("Object Repository not found");
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Unable to load Object Repository");
			e.printStackTrace();
		}
		return prop.getProperty(locatorName);
	}
	
}
