package com.app.testcases;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.base.TestBase;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.pages.OneNeuronPage;

public class OneNeuronPageTest extends TestBase{
	
	
	LoginPage lgnpg;
	HomePage homepage;
	OneNeuronPage ONPage;
	
	public  OneNeuronPageTest() {
		super();
	}
	
	
	@BeforeClass
	public void SetUp() {
		BrowserInitialization();
	}
	@Test(priority = 1)
	public void validateloginclick() {
		lgnpg = PageFactory.initElements(driver, LoginPage.class);
		lgnpg.clicklogin();
		// Switching to the new tab that opened after clicking Login button
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getWindowHandle());
		homepage=lgnpg.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test (priority=2)
	public void verifyClickOneNeuron() {
		
		homepage = PageFactory.initElements(driver, HomePage.class);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		homepage.clickOneNeuron();
		
	}
	
	@Test (priority=3)
	public void verifygetOneNeuronHeading() {
		
	
		ONPage = PageFactory.initElements(driver, OneNeuronPage.class);
		ONPage.getOneNeuronHeading();
	}
	

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
