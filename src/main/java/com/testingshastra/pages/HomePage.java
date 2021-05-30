package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.utilities.Constants;

/**
 * This class represents all locators and operations on IJmeet homepage
 * @author avinashpingale
 *
 */
public class HomePage extends UIKeywords{
	private static final Logger LOG = Logger.getLogger(HomePage.class);
	
	@FindBy(css = "a[href*='register']")
	private WebElement signupBtn;
	
	public HomePage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	public String getTitle() {
		return Constants.driver.getTitle();
	}
	
	public void clickOnSignupBtn() {
		signupBtn.click();
		LOG.info("Clicked on Signup button");
	}
	

}
