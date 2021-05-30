package com.testingshastra.pagetests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.testingshastra.keywords.TestBase;
import com.testingshastra.pages.HomePage;

public class E2ETests extends TestBase{

	@Test
	public void tc_01() {
		HomePage home = new HomePage();
		home.waitFor(2);
	}
}
