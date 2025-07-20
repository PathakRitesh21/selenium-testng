package com.DemoWebShop.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Utils.ConfigUtils;
import Utils.ReportUtils;
import Utils.ScreenshotUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected WebDriver driver;
	
	String configFileName;
	String currentWorkingDirectory;
	Properties configProperty;
	
	String reportFilename;
	ReportUtils reportUtils;
	
	ScreenshotUtils screenshot;
	
	public void initDriver(String driverName) {
		try {
		if (driverName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearResolutionCache().setup();
	    	driver = new ChromeDriver();
	    	driver.manage().window().maximize();
	    	System.out.println("Setup Completed Successfully");
		}}
		catch(Exception e) {
			System.out.println("Error during setup: " +e.getMessage());
			e.printStackTrace();
			Assert.fail("Error during setup: " +e.getMessage());
		}
	}
	
	public void openWebpage(String url) {
		driver.get(url);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void getTitle() {
		driver.getTitle();
	}
	
	public void closeBrowser() {
		if(driver != null) {driver.close();}
		
	}
	
	/*@BeforeSuite
	public void preSetup() throws Exception{
		currentWorkingDirectory = System.getProperty("user.dir");
		configFileName = currentWorkingDirectory + "/config/config.properties" ;
		configProperty = ConfigUtils.readProperties(configFileName);
	}*/
	
	
	@BeforeClass
	public void setUp() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		configFileName = currentWorkingDirectory + "/config/config.properties" ;
		reportFilename = currentWorkingDirectory + "/reports/TestReport.html" ;
		
		configProperty = ConfigUtils.readProperties(configFileName);
		reportUtils = new ReportUtils(reportFilename);
		
		String url = configProperty.getProperty("baseUrl");
		String browser = configProperty.getProperty("browser");

		initDriver(browser); // Driver initialized
		screenshot = new ScreenshotUtils(driver); // Now pass the actual driver
		
		openWebpage(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception {
		String testcasename = result.getName();
		long executionTime = System.currentTimeMillis();
		String screenshotFilename = currentWorkingDirectory + "/screenshot/" + testcasename + executionTime + ".jpeg" ;
		
		if(result.getStatus() == ITestResult.FAILURE) {
			reportUtils.addTestLog(Status.FAIL, "Test Failed");
			screenshot.captureAndSaveScreenshot(screenshotFilename);
		}
		}
	
	@AfterClass
	public void tearDown() {
		try {
			
		if(driver != null) {
			driver.quit();
			driver = null;
			System.out.println("Browser closed Successfully");
			reportUtils.flushReport();
			
		}
		else {
			System.out.println("Browser was already closed.");
		}
		
	}
		catch(Exception e) {
			System.out.println("Error during teardown: " +e.getMessage());
			e.printStackTrace();
			
		}

	}
	
}
