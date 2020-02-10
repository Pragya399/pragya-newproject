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
import com.training.pom.EditdetailsPOM;
import com.training.pom.MaddproductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Editproduct {
	
	private WebDriver driver;
	private String baseUrl;
	private EditdetailsPOM loginadminPOM;
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
		loginadminPOM = new EditdetailsPOM(driver); 
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
		
		//Adding product 
		loginadminPOM.editproduct("Integer vitae iaculis massa", "515");
		screenShot.captureScreenShot("edit product  ");
		
		loginadminPOM.successmsg();
		screenShot.captureScreenShot("successfully edited ");
		
			}


}
