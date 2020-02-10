package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Deleteproduct_044POM;
import com.training.pom.MaddproductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import jxl.read.biff.File;

public class Deleteproduct_044  {

	private WebDriver driver;
	private String baseUrl;
	private Deleteproduct_044POM loginadminPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
    ExtentTest logger;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	} 

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginadminPOM = new Deleteproduct_044POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		String userDir = System.getProperty("user.dir");
		System.out.println("RegisterTest.setUpBeforeClass::userDir:" + userDir);
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/RegistrationExtentReport.html", true);
	   // extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	    logger = extent.startTest("Launching Application URL in Browser");

		// open the browser 
		driver.get(baseUrl);
		System.out.println("Executing Before method");
		String title=driver.getTitle();
		logger.log(LogStatus.PASS, title);
        extent.endTest(logger);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		System.out.println("Executing After method");
		extent.flush();
		extent.close();
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		Actions act=new Actions(driver);
		Thread.sleep(1000);
		loginadminPOM.sendUserName("admin");
		loginadminPOM.sendPassword("admin@123");

		loginadminPOM.selectproduct();
		screenShot.captureScreenShot("data tab");

		loginadminPOM.deletebutton();
		screenShot.captureScreenShot("delete button screen ");
		logger.log(LogStatus.PASS, "Successfully completed clicking on alert");
        extent.endTest(logger);
	}

}
