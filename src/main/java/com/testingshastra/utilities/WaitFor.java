package com.testingshastra.utilities;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitFor {
	private static FluentWait wait = new FluentWait<>(Constants.driver);
	private static final Logger LOG = Logger.getLogger(WaitFor.class);
	
	static{
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
	}
	
	/**
	 * This method will wait for max 30 seconds for {@code element} to be clickable.
	 * It will keep on polling for element for 500 milliseconds
	 * @param element
	 */
	public static void elementToBeClickable(By element) {
		wait.ignoring(ElementClickInterceptedException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void elementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for specified amount of time regardless of state of element
	 * @param milliseconds
	 */
	public static void time(long timeInMilli) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime+timeInMilli;
		while(startTime<endTime) {
			startTime++;
		}
		LOG.info("Wait of "+timeInMilli+" is over");
	}
	public void elementToBeVisible() {

	}
}
