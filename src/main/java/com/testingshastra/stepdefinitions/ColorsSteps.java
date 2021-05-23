package com.testingshastra.stepdefinitions;

import com.testingshastra.keywords.UIKeywords;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;

public class ColorsSteps extends UIKeywords{

	@Given("{string} browser is opened")
	public void launchBrow(String browserName) {
		openBrowser(browserName);
	}
	
	@After
	public void m2() {
		System.out.println("After Scneario");
	}
	
	@BeforeStep
	public void m3() {
		System.out.println("Before Step");
	}
	
	@AfterStep
	public void m4() {
		System.out.println("After Step");
	}
	@Given("I have {int} color(s) in a bag")
	public void iHaveColors(int colorCount) {
		System.out.println("Number of colors: "+colorCount);
	}
	
	
}
