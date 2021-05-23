package com.testingshastra.CustomeListeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.utilities.Constants;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CustomeListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String dir = System.getProperty("user.dir");
		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(300));
		Screenshot sc = ashot.takeScreenshot(Constants.driver);
		BufferedImage img = sc.getImage();
		try {
			ImageIO.write(img, "PNG", new File(dir+"src/test/resources/screenshots/error.png"));
		} catch (IOException e) {
			System.err.println("Unable to save screenshot");
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
