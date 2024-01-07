package com.facebook.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Global Variable 
	WebDriver driver;
	Properties pro;
	
	@FindBy(name="email")   //Using inspect, you have to check 
	WebElement emailID;
	
	@FindBy(name="pass")   //Using inspect, you have to check 
	WebElement userpassword;
	
	@FindBy(name="login")   //Using inspect, you have to check 
	WebElement loginbutton;

	// Create constructor 
	
	public LoginPage(WebDriver driver) throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		propertyFile();   // Need to call in constructor to Execute code of property file
	}
	
	public void setEmail(String email1) 
	{
		emailID.sendKeys(email1);
	}
	
	public void setPassword(String pass1)
	{
		userpassword.sendKeys(pass1);
	}
	
	public void login(String email1, String pass1 )
	{
		emailID.sendKeys(email1);
		userpassword.sendKeys(pass1);
		loginbutton.click();		
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	// Code to property file ( Data provider )
	public Properties propertyFile() throws IOException {

		// Location of Property File (Right click on file --> Property--> Location)
		File src = new File(
				"C:\\Users\\Shraddha\\eclipse\\ecommerceapplication\\test-output\\dataForProjectFacebookProperties");

		// Read Data File (FileInputStream is use to read data file)
		FileInputStream fi = new FileInputStream(src);

		// Create a object of properties for data access
		pro = new Properties();
		pro.load(fi);
		return pro;

		

	}
}
