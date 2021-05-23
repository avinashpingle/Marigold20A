package com.testingshastra.regressiontests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.testingshastra.keywords.UIKeywords;

public class LoginTests {

	@Test
	public void tc_01() {
		UIKeywords ui = new UIKeywords();
		ui.openBrowser("Chrome");
		ui.launchUrl("http://www.testingshastra.com");
		ui.clickOnElement("//a[contains(text(),'Assignments')]");
		ui.clickOnElement("cssSelector", ".xyz");
	}
}

