package com.testingshastra.stepdefinitions;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.testingshastra.keywords.UIKeywords;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstCucumberStepDefinition extends UIKeywords{
	private static final Logger LOG = Logger.getLogger(FirstCucumberStepDefinition.class);
	
	@Given("I have following colors:")
	public void printColors(Map<String,String> colors) {
		System.out.println("All colors passed as an argument");
		Set<Entry<String, String>> entries = colors.entrySet();
		for(Map.Entry<String, String> entry: entries) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		
	}
	
	@Given("browser {string} is opened {float} time")
	public void launchBrowser(String browserName, float count) {
		openBrowser(browserName);
		System.out.println("Parameter: "+count);
		LOG.info("Chrome browser is opened successfully");
	}
	
	@When("we launch url of facebook")
	public void launchUrl() {
		launchUrl("https://www.facebook.com");
		LOG.info("Launching Facebook URL");
	}
	
	@And("click on Create New Account button")
	public void clickOnCreateNewAccountBtn() {
		clickOnElement("CSS", "a[data-testid='open-registration-form-button']");
		LOG.info("Clicked on Create New Account Button");
	}
	
	@Then("we should traverse on Signup page")
	public void we_should_traverse_on_Signup_page() {
		waitFor(3);
		Assert.assertEquals(getWebElement("CSS", "img+div>div:nth-child(1)").getText(), "Sign Up");
	}
}
