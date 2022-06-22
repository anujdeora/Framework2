package com.app.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.TestBase;

public class LoginPage extends TestBase {

//Page Factory (Object repository)
	
	@FindBy(xpath="//a[contains(.,'Login')]")
	WebElement lgnbtn;
	
	@FindBy(xpath="//button[@class='btn btn-light-filled-outline google'][1]")
	WebElement googlelogin;
	
	@FindBy(xpath="//input[@name='email']")	
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement psswrd;
	
	@FindBy(xpath="// button[@type='submit']") 
	WebElement signin;
	
	@FindBy(xpath = "//a[contains(.,'Sign Up')][1]") 
	WebElement signuplink;
	
	//Initializing the page object in constructor
	public LoginPage() {
		
		
		PageFactory.initElements(driver, TestBase.class);
		
	}
	
	//Actions verification
	public String validatePageTitle() {		
		return driver.getTitle();	
	}
 
	public void clicklogin() {
		
		lgnbtn.click();
	}

	
	public HomePage Login(String Username,String Password) {
		
		/*here click on login button will take us to homepage page hence return Homepage- 
		We should have a class of the Homepage to make it a return object*/
		email.sendKeys(Username);
		psswrd.sendKeys(Password);
		signin.click();
		return new HomePage();
	}

}
