package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FilterproductPOM {
	//private static final String String = null;

	private WebDriver driver;

	public FilterproductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-username")
	//@FindBy(xpath="//*[@type='text']")
	private WebElement userName; 

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath="//ul[@id='menu']/li[3]/a")
	private WebElement catlog;

	@FindBy(linkText="Products")
	private WebElement products;
	
	@FindBy(name="filter_name")
	private WebElement productname;
	
	@FindBy(name="filter_price")
	private WebElement productprice;
	
	@FindBy(id="button-filter")
	private WebElement filterbutton;
	
	@FindBy(xpath="//td[contains(text(),'SKU-0031')]")
	private WebElement actualtext;



	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void mouseovercatlog() {
		Actions act=new Actions(driver);
		this.catlog.click();
		
	}
	
	public void productpage() {
		
		this.products.click();
		System.out.println("Title of page = " + driver.getTitle());
		
	}
	
	public void filterproduct(String productname ,String productprice) {
		
		this.productname.sendKeys(productname);
		this.productprice.sendKeys(productprice);
		
		this.filterbutton.click();
		
		String expected_product = "SKU-0031";
		String actual = this.actualtext.getText();
		
		Assert.assertEquals(actual, expected_product);
		System.out.println("Product model no. displayed in list = " + actual);
		
	}

   
}



