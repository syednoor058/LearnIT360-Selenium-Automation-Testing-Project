package com.learnit360.pages;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.learnit360.utilities.BrowserFactory;
import com.learnit360.utilities.ConfigDataProvider;

public class BaseTest {
	
	public static WebDriver driver;
	public ConfigDataProvider config = new ConfigDataProvider();
	
	@BeforeClass
	public void setUp () {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	public void captureScreenShot(WebDriver driver, String testName){
		// Convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot= ((TakesScreenshot)driver);

		// Step 2 :call getScreenshotAs method to capture image file

		File src= screenshot.getScreenshotAs(OutputType.FILE);
		File srcpath=new File("."+"//Screenshots//"+ testName + ".png");

		// Step 3 : copy image file to destination 
		try {
			FileUtils.copyFile(src, srcpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
