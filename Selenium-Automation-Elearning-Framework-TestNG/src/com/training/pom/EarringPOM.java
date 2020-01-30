package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EarringPOM {

	private WebDriver driver;

	public EarringPOM(WebDriver driver) {
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
	
	@FindBy(id="button-filter")
	private WebElement filterbutton;
	
	@FindBy(xpath="//td[contains(text(),'EARRINGS')]")
	private WebElement actualtext;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='selected[]']")
	private WebElement checkbox;
	
	@FindBy(xpath="//button[@type='button' and @class='btn btn-danger']")
	private WebElement deletebtn;



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
	
	public void filterproduct(String productname) {
		
		this.productname.sendKeys(productname);
		
		this.filterbutton.click();
		
		String expected_product = "EARRINGS";
		String actual = this.actualtext.getText();
		
		Assert.assertEquals(actual, expected_product);
		System.out.println("Product name displayed in list = " + actual);
		
	}
	
	public void deleteproduct(){
    this.checkbox.click(); //clicking checkbox
    
    this.deletebtn.click();
    
    Alert alert=driver.switchTo().alert();
    
    
    //Printing message on alert
    System.out.println("Message on alert" + alert.getText());
   
    //cancelling alert
    alert.dismiss();
   
    	
   
}


}
