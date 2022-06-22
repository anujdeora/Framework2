package com.app.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'rohit')]")
	WebElement currentusername;
	
	@FindBy(xpath="//li[normalize-space()='My Courses']")
	WebElement MyCoursesLink;
	
	@FindBy(xpath="//li[contains(text(),'One Neuron')]")
	WebElement OneNeuronLink;
	
	@FindBy(xpath="//li[@class='Header_course-dropdown__18omL'][2]")
	WebElement CoursesDropdown;
	
	@FindBy(xpath="//input[@id='search-bar']")
	WebElement searchbox;
	
	@FindBy(xpath="//li[normalize-space()='My Profile']")
	WebElement Profileicon;
	
	public void HomePage() {
		
		PageFactory.initElements(driver, TestBase.class);
	}
	
	public String verifyHomePageTitle() {
	
	return	driver.getTitle();
		
	}
	
	public void clickOnCoursesDD() {
		CoursesDropdown.click();
	}
	
	public String SearchBoxFunctionality(String SearchText) {
		
		searchbox.click();
	    searchbox.sendKeys(SearchText);
		 searchbox.sendKeys(Keys.ENTER);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 return SearchText;
		}
		
	
	public void clickOneNeuron()
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(OneNeuronLink));
		OneNeuronLink.click();
	}
	
	public void getnameOfUser() {
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(OneNeuronLink));
		System.out.println(currentusername.getText());
		
	}
	
	public ProfilePage clickOnProfile() {
		
		Actions act = new Actions(driver);
		act.moveToElement(currentusername).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 Profileicon.click();
		 return new ProfilePage();
		
		
		
	}
	
	
	
	

}
