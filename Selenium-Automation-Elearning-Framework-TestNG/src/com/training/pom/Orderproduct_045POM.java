package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderproduct_045POM {
	
	private WebDriver driver;

	public Orderproduct_045POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
    private WebElement salesbtn;
	
	@FindBy(xpath="//div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[1]/a[1]")
	private WebElement orderbtn;
	
	@FindBy(xpath="//tr[3]//td[8]//a[1]")
	private WebElement viewbtn;
	
	@FindBy(xpath="//button[@id='button-invoice']")
	private WebElement invoicebtn;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		this.loginBtn.click();
	}
	
	public void clicksales() {
	
		this.salesbtn.click();
		
		//getting list on sales tab 
		String beforexpath= "//div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[";
		String afterxpath = "]/a[1]";
		
		int i =1;
		//getting size of list 
		int count = driver.findElements(By.xpath("//div[1]/nav[1]/ul[1]/li[6]/ul[1]/li")).size();
		System.out.println("No of elements are " +count );
		
		//for loop to create xpath and generate a list of options present on sales tab 
		for(i=1;i<=count;i++)
		{
			//Xpath concatination methods
			String List = driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			
			System.out.println(" Element on list is " + List);
			
						}
			
          this.orderbtn.click();
          
			}
			
			public void view() {
				
				this.viewbtn.click();
	
		}
			public void invoice_generation() {
			//	this.invoicebtn.click();
				
	
		
	 

}
}