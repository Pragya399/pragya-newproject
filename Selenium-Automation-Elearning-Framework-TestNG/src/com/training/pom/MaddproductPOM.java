package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MaddproductPOM {

	private WebDriver driver;

	public MaddproductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//login elements
	@FindBy(id="input-username")
	private WebElement userName; 

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;


	//clicking on catlog button
	@FindBy(xpath="//ul[@id='menu']/li[3]/a")
	private WebElement catlog;

	//clicking on product button
	@FindBy(linkText="Products")
	private WebElement products;

	//adding element
	@FindBy(xpath="//div[@class='pull-right']/a[1]")
	private WebElement addicon;

	@FindBy(name="product_description[1][name]")
	private WebElement productname;

	@FindBy(name="product_description[1][meta_title]")
	private WebElement metatag;

	//Elements of data tab 

	@FindBy(linkText="Data")
	private WebElement datatab;

	@FindBy(name="model")
	private WebElement model;

	@FindBy(name="price")
	private WebElement price;

	@FindBy(name="quantity")
	private WebElement quantity;
	
	//link tab 
	@FindBy(linkText="Links")
	private WebElement links;
	
	@FindBy(name="category")
	private WebElement category;

	//Clicking on filter button
	@FindBy(id="button-filter")
	private WebElement filterbutton;




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

	public void addproduct() {

		//click on add button 
		this.addicon.click();

		String actualtitle=driver.findElement(By.xpath("//div[@class='panel-heading']")).getText();
		String expectedtitle="Add Product";
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("title of page is " + actualtitle);

		this.productname.sendKeys("Finger Ring");

		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0 ,document.body.scrollHeight)");

		this.metatag.sendKeys("Finger Ring for ladies");
		js.executeScript("window.scrollTo(0 ,-document.body.scrollHeight)");

	}

	public void datatab() {

		this.datatab.click();
		this.model.sendKeys("SKU-012");

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();

		this.price.sendKeys("500");
		this.quantity.sendKeys("50");

		act.sendKeys(Keys.PAGE_UP).perform();
	}

	public void linkstab() {
		this.links.click();
		this.category.click();
		this.category.sendKeys("earrings");
			
		
	}



}









