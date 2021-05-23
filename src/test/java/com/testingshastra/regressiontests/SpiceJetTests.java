package com.testingshastra.regressiontests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.List;

import javax.management.DescriptorKey;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.utilities.Constants;
import com.testingshastra.utilities.OR;

import io.qameta.allure.Description;

public class SpiceJetTests extends UIKeywords {

	@BeforeMethod
	public void setUp() {
		openBrowser("Chrome");
		launchUrl("https://www.spicejet.com/");
	}

	@AfterMethod
	public void tearDown() {
		Constants.driver.quit();
		System.out.println("Closed all browser windows");
	}

	@Description("Verify two options under SpiceClub Members from Login dropdown")
	@Test
	public void verifyLoginOptionsUnderSpiceClubMembers() {
		moveToElement(OR.getLocator("homepage.login_signup_btn"));
		
		moveToElement(OR.getLocator("homepage.spiceclub_member"));
		
		List<String> menueOptions = getTextOfAllElements("xpath",
				"//li[@class='li-login float-right tabres']/ul/li[2]/ul/li/a");
		AssertJUnit.assertTrue(menueOptions.contains("Member Login"));
		AssertJUnit.assertTrue(menueOptions.contains("Sign up"));
	}

	@Test
	public void verifySignUpForSpiceClubMember() {
		moveToElement("xpath", "//div[@id='smoothmenu1']/descendant::a[contains(text(),'Login / Signup')]");
		moveToElement("xpath", "//a[contains(text(),'SpiceClub Members')]");
		waitForElementToBeClickable("xpath", "//*[contains(text(),'Sign up')]", 5000);
		clickOnElement("//*[contains(text(),'Sign up')]");
		waitForElementToBePresent("xpath", "//select[contains(@id,'Title')]", 10000);
		selectFromDropDown("xpath", "//select[contains(@id,'Title')]", "MR");
		enterText("xpath", "//input[contains(@name,'FirstName')]", "Avinash");
		enterText("xpath", "//input[contains(@name,'LastName')]", "Pingale");
		enterText("xpath", "//input[contains(@name,'MOBILENUMBER')]", "9988706655");
		enterText("xpath", "//input[contains(@name,'Password')]", "Abcsdf@123");
		enterText("xpath", "//input[contains(@name,'PasswordConfirm')]", "Abcsdf@123");
		clickOnElement("//input[contains(@name,'INPUTDOB')]");
		List<String> allYears = getTextOfAllElements("xpath", "//tbody[@class='datepickerYears']/descendant::span");
		boolean isContain = false;
		while (!isContain) {
			isContain = allYears.contains("1987");
			if (isContain) {
				clickOnElement("//span[contains(text(),'1987')]");
				break;
			} else {
				clickOnElement("//th[@class='datepickerGoPrev']/a");
				allYears = getTextOfAllElements("xpath", "//tbody[@class='datepickerYears']/descendant::span");
			}
		}
		clickOnElement("//span[contains(text(),'Mar')]");
		clickOnElement("//tbody[@class='datepickerDays']/descendant::td[@class='validDate']/a/span[text()='2']");
	}

}
