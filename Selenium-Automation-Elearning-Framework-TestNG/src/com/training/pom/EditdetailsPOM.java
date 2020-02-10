package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditdetailsPOM {

	private WebDriver driver;

	public EditdetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-username")
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

	//clicking on edit button 
	@FindBy(xpath ="//td[@class='text-right']//a[@class='btn btn-primary']")
	private WebElement editbtn;

	@FindBy(linkText="Data")
	private WebElement datatab;

	@FindBy(name="quantity")
	private WebElement quantity;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement savebtn;

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
		this.catlog.click();


	}

	public void productpage() {

		this.products.click();
		System.out.println("Title of page = " + driver.getTitle());

	}

	public void editproduct(String productname ,String productprice) {

		//Entering product name and price to filter 
		this.productname.sendKeys(productname);
		this.productprice.sendKeys(productprice);

		this.editbtn.click();

		this.datatab.click();


		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_UP).perform();

		this.quantity.clear();
		this.quantity.sendKeys("45");



		this.savebtn.click();
	}


	public void successmsg() {
		String expected ="Success: You have modified products!";
		String actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		Assert.assertEquals(actual, expected);
		System.out.println("Success alert message is  "+ actual);


	}




}










