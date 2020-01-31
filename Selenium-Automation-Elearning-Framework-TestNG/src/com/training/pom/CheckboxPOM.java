package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckboxPOM {
private WebDriver driver; 
	
	public CheckboxPOM(WebDriver driver) {
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
	
	@FindBy(linkText="Categories")
	private WebElement categories;
	
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement pagetitle;
	
	//find element to click checkbox
	@FindBy(linkText=">")
	private WebElement page2;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='665']")
	private WebElement checkbox;
	
	//Locator to find delete button
	@FindBy(xpath="//button[@type='button']")
	private WebElement delete;
	
		
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
	//	Actions act=new Actions(driver);
		this.catlog.click();
	}
	
	public void categories() {
		this.categories.click();
		String actual=this.pagetitle.getText();
		String expected = "Category List";
		Assert.assertEquals(actual, expected);
		System.out.println("Category page is displayed successfully");

    }
	
	public void clickcheckbox() {
		
		//Scroll down the page 
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		act.sendKeys(Keys.PAGE_DOWN).perform();
		this.page2.click();
		act.sendKeys(Keys.PAGE_UP).perform();
		//Selecting check box
		String category_selected=this.checkbox.getText();
		System.out.println("Element selected "+ category_selected );
		
		this.checkbox.click();
		
	}
	
	public void clickdelete() throws InterruptedException {
		this.delete.click();
        
		//Adding alert class to handle delete alert 
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		
	}
	}
	
