package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.utilities.Constants;

public class HomePage extends UIKeywords{
	private static final Logger LOG = Logger.getLogger(HomePage.class);
	@FindBy(css="a#Login")
	public WebElement loginOrSignUp;
	
	@FindBy(css="a#Login+ul>li:nth-child(1)>a")
	public WebElement spiceClubMembers;
	
	@FindBy(css="a[href='Register.aspx']")
	public WebElement signup;
	
	public HomePage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	public void moveMouseToLoginOrSignup() {
		moveToElement(loginOrSignUp);
		LOG.info("moved mouse on Login/Signup on homepage");
	}
	
	public void moveMouseToSpiceClubMembers() {
		moveToElement(spiceClubMembers);
		LOG.info("Moved mouse on Spiceclub members on homepage");
	}

	public void clickOnSignup() {
		clickOnElement(signup);
		LOG.info("Clicked on Signup link");
	}
	
	

}
