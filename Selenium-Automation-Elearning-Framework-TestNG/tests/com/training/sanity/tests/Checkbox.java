package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CheckboxPOM;
import com.training.pom.ClickcatlogPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Checkbox {
	private WebDriver driver;
	private String baseUrl;
	private CheckboxPOM loginadminPOM;
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
		loginadminPOM = new CheckboxPOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
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
		
		//clicking checkbox
		loginadminPOM.clickcheckbox();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Checked box");
		
		loginadminPOM.clickdelete();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Alert for delete ");
		
		
		
	}
	
	

	
}
