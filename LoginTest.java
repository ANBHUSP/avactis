package com.facebook.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.facebook.pages.LoginPage;

public class LoginTest {

	//Global Variable 
	
	WebDriver driver;     // To use driver
	LoginPage loginPageObj;  // Class Object to call constructor
	Properties pro;
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver=new ChromeDriver();
		loginPageObj=new LoginPage(driver);
		pro = loginPageObj.propertyFile();
		driver.get(pro.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.close();
	}
	
	@Test
	public void VerifyTitle()
	{
		loginPageObj.login(pro.getProperty("Email"), pro.getProperty("Password"));
		String titleofpage=loginPageObj.getTitle();
		System.out.println(titleofpage);
		Assert.assertEquals(titleofpage,"Log in to Facebook");
	}

}

/*
 * Page Object model Package--- Pages Test---Test cases Global Variable
 * (Web-driver and Web-element) Constructor (WedDriver, initial, WedElement,
 * initial (PageFactory.initElement)) Test----> Constructor Object-----Setup
 * Element(BeforeTest)----- Actual Test case
 */
 

