package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EarringPOM;
import com.training.pom.FilterproductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Earring {
	
	private WebDriver driver;
	private String baseUrl;
	private EarringPOM loginadminPOM;
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
		loginadminPOM = new EarringPOM(driver); 
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
		//clicking on product and check if the page is displayed 
		loginadminPOM.productpage();
		screenShot.captureScreenShot("Products list");
		
		//Putting earrings in product name for filtering 
		loginadminPOM.filterproduct("EarRings");
		screenShot.captureScreenShot( "Filtered product list");
		
		//deleting product 
		loginadminPOM.deleteproduct();
		screenShot.captureScreenShot( "clicking on checkbox");
		
		screenShot.captureScreenShot("clicking on delete button");
		
		screenShot.captureScreenShot("getting alert ");
		
		
	}

}
