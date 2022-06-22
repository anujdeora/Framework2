package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.TestBase;

public class ProfilePage extends TestBase {

	@FindBy(xpath="//input[@name='social.facebook']")
	WebElement facebook;
	
	@FindBy(xpath="//input[@name='social.twitter']")
	WebElement twitter;
	
	@FindBy(xpath="//input[@name='social.instagram']")
	WebElement instagram;
	
	@FindBy(xpath="//input[@name='social.linkedin']")
	WebElement linkedin;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Save;
	
	
	
	//initializing page objects
	public ProfilePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getProfilePageTitle() {
		
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public void enterdataonProfile(String Facebk, String twittr, String insta, String linkdin) {
		
		facebook.sendKeys(Facebk);
		twitter.sendKeys(twittr);
		instagram.sendKeys(insta);
		linkedin.sendKeys(linkdin);
		Save.click();
		
	}
	
	
}
