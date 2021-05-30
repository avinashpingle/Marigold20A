package com.testingshastra.stepdefinitions;

import org.apache.log4j.Logger;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.utilities.Constants;
import com.testingshastra.utilities.FileUtilities;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class ConfigSteps {
	private static final Logger LOG = Logger.getLogger(ConfigSteps.class);

	static UIKeywords keyword = new UIKeywords();
	
	@Step
	@Given("{string} browser is opened")
	public void openBrowser(String browserName) {
		UIKeywords keyword = new UIKeywords();
		keyword.openBrowser(browserName);
	}
	
	@Step
	@Given("Application url is launced")
	public void application_url_is_launced() {
		keyword.launchUrl(FileUtilities.getAppUrl());
	}
	
	@After
	public void closeBrowser() {
		Constants.driver.close();
		LOG.info("Browser is closed");
	}
}
