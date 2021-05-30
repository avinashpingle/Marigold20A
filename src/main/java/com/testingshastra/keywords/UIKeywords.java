package com.testingshastra.keywords;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.testingshastra.utilities.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {
	private static Logger log = Logger.getLogger(UIKeywords.class);
	
	
	/**
	 * This keyword is used to launch specified {@code browser}
	 * List of browsers supported: 
	 * <ul>
	 * <li>Chrome</li>
	 * <li>Firefox</li>
	 * <li>Safari</li>
	 * <li>IE</li>
	 * @param browserName browser name must be one of the mentioned list
	 */
	public void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Safari")) {
			Constants.driver = new SafariDriver();
		}
		log.info("Launching browser: "+browserName);
	}
	
	public void launchUrl(String url) {
		Constants.driver.get(url);
		log.info("Launching url: "+url);
	}
	
	public void clickOnElement(String xpath) {
		Constants.driver.findElement(By.xpath(xpath)).click();
		log.info("Clicked on element");
	}
	
	public void clickOnElement(String locatorType, String locatorValue){
		getWebElement(locatorType, locatorValue).click();
	}

	public void clickOnElement(WebElement e) {
		e.click();
	}
	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element=null;
		if(locatorType.equalsIgnoreCase("xpath")) {
			element = Constants.driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")) {
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
		}else if(locatorType.equalsIgnoreCase("id")) {
			element = Constants.driver.findElement(By.id(locatorValue));
		}else if(locatorType.equalsIgnoreCase("name")) {
			element = Constants.driver.findElement(By.name(locatorValue));
		}else if(locatorType.equalsIgnoreCase("classname")) {
			element = Constants.driver.findElement(By.className(locatorValue));
		}else {
			System.err.println("Invalid locator type");
		}
		
		return element;
	}
	
	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> allElements = new ArrayList<WebElement>();
		if(locatorType.equalsIgnoreCase("xpath")) {
			allElements = Constants.driver.findElements(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")) {
			allElements = Constants.driver.findElements(By.cssSelector(locatorValue));
		}else if(locatorType.equalsIgnoreCase("id")) {
			allElements = Constants.driver.findElements(By.id(locatorValue));
		}else if(locatorType.equalsIgnoreCase("name")) {
			allElements = Constants.driver.findElements(By.name(locatorValue));
		}else if(locatorType.equalsIgnoreCase("classname")) {
			allElements = Constants.driver.findElements(By.className(locatorValue));
		}else {
			System.err.println("Invalid locator type");
		}
		return allElements;
		
	}
	/**
	 * This method is deprecated. You can instead use {@code moveToElement(String orElement)}
	 * @param locatorType
	 * @param locatorValue
	 */
	@Deprecated
	public void moveToElement(String locatorType, String locatorValue) {
		Actions action = new Actions(Constants.driver);
		action.moveToElement(getWebElement(locatorType, locatorValue));
		action.build().perform();
		log.info("Moved cursor on lement");
		
	}
	
	public void moveToElement(String orElement) {
		String[] parts = orElement.split("##");
		moveToElement(parts[0],parts[1]);
	}
	
	public void moveToElement(WebElement element) {
		Actions action = new Actions(Constants.driver);
		action.moveToElement(element);
		action.build().perform();
		log.info("Moved cursor on lement "+element.getText());
	}
	
	public void getTextOfElement() {

	}
	
	public void enterText(String locatorType, String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}
	public void selectFromDropDown(String locatorType, String locatorValue, String option) {
		WebElement dropDown = getWebElement(locatorType, locatorValue);
		Select select = new Select(dropDown);
		select.selectByVisibleText(option);
	}
	public List<String> getTextOfAllElements(String locatorType, String locatorValue) {
		List<WebElement> allElements = getWebElements(locatorType, locatorValue);
		List<String> elementText = new ArrayList<>();
		for (WebElement element : allElements) {
			elementText.add(element.getText());
		}
		return elementText;
	}
	public FluentWait getWait(long timeOut) {
		FluentWait wait = new FluentWait(Constants.driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofMillis(timeOut));
		return wait;
	}
	/**
	 * This method will hault execution for specified seconds
	 * @param timeInSeconds
	 */
	public void waitFor(int timeInSeconds) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime+(timeInSeconds*1000);
		while(startTime!=endTime) {
			startTime = System.currentTimeMillis();
		}
		log.info("Wait is finished");
	}
	public void waitForElementToBeClickable(String locatorType, String locatorValue,long timeOut) {
		getWait(timeOut).until(ExpectedConditions.elementToBeClickable(getWebElement(locatorType, locatorValue)));
		log.info("Element appeared and ready to click");
	}
	
	public void waitForElementToBePresent(String locatorType, String locatorValue,long timeOut) {
		long startTime = System.currentTimeMillis();//12:05:00
		long endTime = startTime+timeOut;//12:05:05
		List<WebElement> elements = new ArrayList<>();
		while(startTime<=endTime) {
			elements = getWebElements(locatorType, locatorValue);
			if(elements.size()>0) {
				log.info("Title element is appeared");
				break;
			}
			startTime = System.currentTimeMillis();
		}
		if(elements.isEmpty()) {
			log.info("Element is not appeared within timeout");
		}else {
			log.info("Element appeared on page");
		}
	}
	
	public JavascriptExecutor getJavaScriptExecutor() {
		return (JavascriptExecutor)Constants.driver;
	}
	
	public void executeScript(String script) {
		getJavaScriptExecutor().executeAsyncScript(script);
	}
}
