package com.testingshastra.stepdefinitions;

import org.testng.Assert;

import com.testingshastra.pages.HomePage;
import com.testingshastra.utilities.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class IJMeetHomePageSteps {
	String title = "";
	
	@Given("Title is stored in veriable")
	public void getTitleOfHomePage() {
		HomePage homePage = new HomePage();
		title = homePage.getTitle();
		System.out.println("Got title: "+title);
	}
	
	@Then("check that title is equals to {string}")
	public void verifyTitleOfHomePage(String expectedTitle) {
		System.out.println("Expected Title: "+expectedTitle);
		Assert.assertEquals(expectedTitle, title,"Title is wrong: "+title);
	}
}
