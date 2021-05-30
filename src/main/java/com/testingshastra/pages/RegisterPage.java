package com.testingshastra.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.utilities.Constants;
import com.testingshastra.utilities.WaitFor;

public class RegisterPage extends UIKeywords {
	private static final Logger LOG = Logger.getLogger(RegisterPage.class);
	@FindBy(css = "input#name")
	WebElement fullName;
	@FindBy(css = "input#company_name")
	WebElement companyName;
	@FindBy(css = "input#email")
	WebElement emailId;
	@FindBy(css = "input#contact")
	WebElement mobieNumber;
	@FindBy(css = "input#password")
	WebElement password;
	@FindBy(css = "button[type='submit']")
	WebElement signupBtn;
	@FindBy(css = "div.input-group+label[id='contact-error-server']")
	WebElement mobileErrorMsg;

	public RegisterPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public void enterFullName(String fullName) {
		this.fullName.sendKeys(fullName);
	}

	public void enterCompanyName(String companyName) {
		this.companyName.sendKeys(companyName);
		LOG.info("Entered company name");
	}

	public void enterEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
		LOG.info("Enntered Email ID as: " + emailId);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
		LOG.info("Entered password as: " + password);
	}

	public void enterMobileNumber(String mobileNumber) {
		this.mobieNumber.sendKeys(mobileNumber);
	}

	public void clickOnIAmNotRobot() {
		WebElement frame = Constants.driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']"));
		Constants.driver.switchTo().frame(frame);
		Constants.driver.findElement(By.cssSelector("span.recaptcha-checkbox")).click();
		Constants.driver.switchTo().defaultContent();
	}

	public String getMobileNumberErrorMessage() {
		return mobileErrorMsg.getText();
	}

	public void clicOnSignup() {
		executeScript("document.querySelector(\"button[type='submit']\").click()");
		LOG.info("Clicked on Signup button");
	}
}
