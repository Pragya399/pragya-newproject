package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deleteproduct_044POM {

	private WebDriver driver;

	public Deleteproduct_044POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

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

	//clicking on delete button 
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deletebtn;





	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		this.loginBtn.click();
	}

	public void selectproduct() {

		this.catlog.click();
		this.products.click();

		//getting list on sales tab 
		String beforexpath= "//tbody/tr[";
		String afterxpath = "]/td[3]";

		int i =1;
		//getting size of list 
		int count = driver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println("No of elements are " +count );

		//for loop to create xpath and generate a list of options present on sales tab 
		for(i=1;i<=count;i++)
		{
			//Xpath concatination methods
			String List = driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			String product1 ="Finger Ring";
			String product2= "EARRINGS";
			if(List.equals(product1)) {
				System.out.println("Element found is " + List);
				WebElement checkbox=driver.findElement(By.xpath(beforexpath + i +"]/td[1]/input[1]"));
				checkbox.click();



			}else if(List.equals(product2)) {
				System.out.println("Element found is " + List);
				WebElement checkbox=driver.findElement(By.xpath(beforexpath + i +"]/td[1]/input[1]"));
				checkbox.click();

			}
		}
	}

	public void deletebutton() {

		this.deletebtn.click();

		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		//Thread.sleep(2000);
		alert.dismiss();

	}

}
