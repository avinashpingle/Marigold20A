package com.testingshastra.stepdefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.RegisterPage;
import com.testingshastra.utilities.Randomize;
import com.testingshastra.utilities.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IJMeetSignupPageSteps {
	private static RegisterPage register = new RegisterPage();
	private static final Logger LOG = Logger.getLogger(IJMeetSignupPageSteps.class);
	private String expectedErrorMessage = "Contact number should be minimum 8 digit";

	@Given("Signup page is opened")
	public void signup_page_is_opened() {
		HomePage home = new HomePage();
		home.clickOnSignupBtn();
	}

	@Then("Enter Fullname as {string}")
	public void enter_Firstname(String fullName) {
		register.enterFullName(fullName);
	}

	@Then("Enter company name as {string}")
	public void enterCompanyName(String companyName) {
		register.enterCompanyName(companyName);
	}

	@And("Enter email id as {string}")
	public void enter_email_id(String email) {
		if(email.equalsIgnoreCase("Random")) {
			email = Randomize.email();
		}
		register.enterEmailId(email);
	}

	@Then("Enter mobile number as {string}")
	public void enter_mobile_number_as(String mobileNumber) {
		register.enterMobileNumber(mobileNumber);
	}

	@Then("Verify that user is getting error for length of contact number")
	public void verify_that_user_is_getting_error_for_length_of_contact_number() {
		String actualMsg = register.getMobileNumberErrorMessage();
		Assert.assertEquals(actualMsg, expectedErrorMessage, "Error messager are not a match: " + actualMsg);
	}

	@And("Enter password as {string}")
	public void enterPassword(String password) {
		register.enterPassword(password);
	}

	@And("Click on I am not robot checkbox")
	public void clickOnIAmNotRobot() {
		register.clickOnIAmNotRobot();
	}

	@When("User clicks on Signup button")
	public void clickOnSignupButton() {
		WaitFor.time(2000);
		try {
			register.clicOnSignup();
		} catch (Exception e) {
			
		}
		
	}
}
