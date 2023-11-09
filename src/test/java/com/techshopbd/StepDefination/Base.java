package com.techshopbd.StepDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techshopbd.utility.Utility;

import io.cucumber.java.Scenario;

abstract class Base {

	private static WebDriver driver;
	private Utility utility;
	private static byte[] screenshot;

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//Drivers//chromedrivernew.exe");
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}

	public Utility getUtilityClass() {
		utility = new Utility();
		return utility;
	}

	public static void addscreenShot(Scenario scenario) {

		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");
	}

}
