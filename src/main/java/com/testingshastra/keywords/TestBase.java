package com.testingshastra.keywords;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingshastra.utilities.Constants;
import com.testingshastra.utilities.FileUtilities;

public class TestBase {
	private static final Logger LOG = Logger.getLogger(TestBase.class);
	@BeforeMethod
	public void setup() {
		String brwoserName = FileUtilities.getBrowserName();
		UIKeywords keyword = new UIKeywords();
		keyword.openBrowser(brwoserName);
		String url = FileUtilities.getAppUrl();
		LOG.info("Browser launched successfully: "+brwoserName);
		keyword.launchUrl(url);
		LOG.info("Url is launched: "+url);
	}
	
	@AfterMethod
	public void tearDown() {
		Constants.driver.close();
		LOG.info("Browser is closed successfully");
	}
}
