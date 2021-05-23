package com.testingshastra.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"./src/test/resources/Features"},
				glue="com.testingshastra.stepdefinitions")
public class Runner extends AbstractTestNGCucumberTests{

}