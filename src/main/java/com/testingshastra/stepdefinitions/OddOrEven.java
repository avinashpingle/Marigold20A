package com.testingshastra.stepdefinitions;


import java.util.List;

import org.testng.Assert;

import com.testingshastra.utilities.FileUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OddOrEven {
	int x, y;
	int result;

	@Given("I have {int} and {int}")
	public void getNumbers(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@When("I add both numbers")
	public void addNumbers() {
		result = x + y;
	}
	
	@Then("check whetehr the addition is even")
	public void checkForEven() {
		Assert.assertTrue(result%2==0,"Result is not even: "+result);
	}

	@When("I have numbers from {int} row")
	public void getNumbersFromFile(int rowNum) {
		String baseDir = System.getProperty("user.dir");
		
		FileUtilities fileUtil = new FileUtilities();
		List data = fileUtil.getRowData(rowNum, baseDir+"/src/test/resources/TestData/Numbers.xlsx", "Sheet1");
		double a = (double)data.get(0); //Double
		double b = (double)data.get(1);
		
		x = (int)a;
		y = (int)b;
		
	}
}
