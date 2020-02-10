package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MfilterappPOM {

	private WebDriver driver;

	public MfilterappPOM(WebDriver driver) {
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
    
	
	@FindBy(name="filter_name")
	private WebElement productname;

	@FindBy(name="filter_price")
	private WebElement productprice;

	//Clicking on filter button
	@FindBy(id="button-filter")
	private WebElement filterbutton;
	
	//part2-find element to Select status
	@FindBy(name="filter_status")
	private WebElement status;
	
	//part3-Entering model no 
	@FindBy(name="filter_model")
	private WebElement modelno;
	
	//find element to Select quantity 
	@FindBy(name="filter_quantity")
	private WebElement qunatity;
	
	//find element to Select image status
	@FindBy(name="filter_image")
	private WebElement image;
	
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
		this.catlog.click();
		

	}

	public void productpage() {

		this.products.click();
		System.out.println("Title of page = " + driver.getTitle());

	}

	public void filterproductname(String productname ,String productprice) {

		//Entering product name and price to filter 
		this.productname.sendKeys(productname);
		this.productprice.sendKeys(productprice);

		this.filterbutton.click();

		//Verifying the model number of product and printing it 
		String expected_product = "SKU-0031";
		String actual = this.actualtext.getText();

		Assert.assertEquals(actual, expected_product);
		System.out.println("Product model no. displayed in list = " + actual);

	}
	
	public void filtermodel(String modelno ) {

		//Entering product name and price to filter 
		this.modelno.sendKeys(modelno);
		this.productname.clear();
		this.productprice.clear();

		this.filterbutton.click();

		//Verifying the model number of product and printing it 
		String expected_product = "SKU-0031";
		String actual = this.actualtext.getText();

		Assert.assertEquals(actual, expected_product);
		System.out.println("Product model no. displayed in list = " + actual);

	}
	
	public void selectstatus() {
		
		Select status = new Select(driver.findElement(By.name("filter_status")));
		status.selectByVisibleText("Enabled");
		this.modelno.clear();
		this.filterbutton.click();
		
		//verification point 
		String expectedstatus="Enabled";
		String actualstring = driver.findElement(By.xpath("//tbody//tr[1]//td[7]")).getText();
		
		Assert.assertEquals(actualstring, expectedstatus);
		
		System.out.println("Actual status is " + actualstring);
		
	}
	
	public void selectquantity(String qunatity) {
		this.qunatity.sendKeys(qunatity);
		
		Select status = new Select(driver.findElement(By.name("filter_status")));
		status.selectByValue("*");
		
		this.filterbutton.click();
		
		String expectedquantity="10";
		String actualquantity = driver.findElement(By.xpath("//tbody//tr[1]//td[6]")).getText();
		
		Assert.assertEquals(actualquantity, expectedquantity);
		
		System.out.println("Actual quantity is " + actualquantity);
		
		
		
	}
	
	public void imagestatus() {
		this.image.click();
		
		Select imagedrp =new Select(image);
		imagedrp.selectByVisibleText("Enabled");
		this.qunatity.clear();
		
		this.filterbutton.click();
		
		String expectedstatus="No results!";
		String actualstatus=driver.findElement(By.xpath("//td[contains(text(),'No results!')]")).getText();
		
		Assert.assertEquals(actualstatus, expectedstatus);
		
		System.out.println("Image staus results = " + actualstatus );
		
	}


}






