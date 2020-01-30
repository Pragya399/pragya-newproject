package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ClickcatlogPOM {
private WebDriver driver; 
	
	public ClickcatlogPOM(WebDriver driver) {
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
	
	//detecting heading elements on category table 
	
	@FindBy(linkText="Category Name")
	private WebElement categoryname;
	
	@FindBy(linkText="Sort Order")
	private WebElement SortOrder;
	
	@FindBy(xpath="//td[contains(text(),'Action')]")
	private WebElement action;
	
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
	
	public void categories() {
		this.categories.click();
		String actual=this.pagetitle.getText();
		String expected = "Category List";
		Assert.assertEquals(actual, expected);
		System.out.println("Category page is displayed successfully");
		
		String actual2=this.categoryname.getText();
		String expected2= "Category Name";
		Assert.assertEquals(actual2, expected2);
		System.out.println("1st column heading is " + actual2);
		
		String actual3=this.SortOrder.getText();
		String expected3= "Sort Order";
		Assert.assertEquals(actual3, expected3);
		System.out.println("2st column heading is " + actual3);
		
		String actual4=this.action.getText();
		String expected4= "Action";
		Assert.assertEquals(actual3, expected3);
		System.out.println("3st column heading is " + actual4);
		
			}
	
	
}

	