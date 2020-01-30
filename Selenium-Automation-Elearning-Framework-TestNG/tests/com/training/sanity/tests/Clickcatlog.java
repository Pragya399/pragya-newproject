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

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.*;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginadminPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Clickcatlog {

	private WebDriver driver;
	private String baseUrl;
	private ClickcatlogPOM loginadminPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	} 

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginadminPOM = new ClickcatlogPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		//Actions act=new Actions(driver);
		//.sleep(1000);
		loginadminPOM.sendUserName("admin");
		loginadminPOM.sendPassword("admin@123");
		loginadminPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		loginadminPOM.mouseovercatlog();
		//clicking on categories and check if the page is displayed 
		loginadminPOM.categories();
		screenShot.captureScreenShot("category table");
		
		
		
		
		
	}
}
