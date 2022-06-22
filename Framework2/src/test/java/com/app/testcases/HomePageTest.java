package com.app.testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.base.TestBase;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.utils.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage lgnpg;
	HomePage homepage;
	TestUtil testutils;

	public HomePageTest() {
		super();
	}
	
	//Here in the below method prop object reference could be used because we hve used Super keyword in the 
	//constructor through which we can use the  properties class of the TestBase class. This is inheritance. As HomepageTest is the child class and TestBase is superclass
	@BeforeClass
	public void SetUp() {
		BrowserInitialization();
	}
	@Test(priority = 1)
	public void validateloginclick() {
		lgnpg = PageFactory.initElements(driver, LoginPage.class);
		lgnpg.clicklogin();
		// Switching to the new tab that opened after clicking Login button
		testutils=new TestUtil();
		testutils.switchHandles();
		System.out.println(driver.getWindowHandle());
		homepage=lgnpg.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test (priority=6)
	public void verifyClickOneNeuron() {
		
		
		homepage.clickOneNeuron();
		
	}
	
	@Test (priority=4)
	public void verifyClickOnCoursesDropdown() {
		
		
		homepage.clickOnCoursesDD();
		
	}
	
	@Test (priority=5)
	public void verifySearchBoxFunctionality()
	{
		System.out.println(prop.getProperty("searchtext"));
		homepage.SearchBoxFunctionality(prop.getProperty("searchtext"));
	}

	@Test (priority=2)
	public void verifyHomePageTitle() {
		//Here the driver from login page was switched to driver from the Homepage and the tab focus was switched from 0 to 1. i.e. current tab
		homepage = PageFactory.initElements(driver, HomePage.class);
		testutils = new TestUtil();
		testutils.switchHandles();
		String hptitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(hptitle, "Sign In | iNeuron.ai");
		
	}
	
	@Test (priority=3)
	public void VerifygetnameOfUser() {
		
		homepage.getnameOfUser();
	}
	
	@Test (priority=7)
	public void VerifyClickOnProfile() {
		
		homepage.clickOnProfile();
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
