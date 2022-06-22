package com.app.testcases;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.base.TestBase;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;

public class LoginPageTest extends TestBase {

	HomePage homepage;

	// Calling the superclass constructor with super keyword
	public LoginPageTest() {
		super();
	}

	// Creating object of the LoginPage class so that its method can be accessed
	LoginPage lgnpg = new LoginPage();

	@BeforeClass
	public void SetUp() {
		BrowserInitialization();
	}

	@Test(priority = 1)
	public void validateloginpagetitle() {

		String title1 = lgnpg.validatePageTitle();
		Assert.assertEquals(title1, "Affordable & Competent Courses | iNeuron.ai");
		System.out.println(driver.getWindowHandle());
	}

	@Test(priority = 2)
	public void validateloginclick() {
		lgnpg = PageFactory.initElements(driver, LoginPage.class);
		lgnpg.clicklogin();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		// Switching to the new tab that opened after clicking Login button
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getWindowHandle());
		
	}

	/*Here in the below method prop object reference could be used because we hve used Super keyword in the 
	constructor through which we can use the  properties class of the TestBase class. This is inheritance. 
	As HomepageTest is the child class and TestBase is superclass*/
	@Test(priority = 3)
	public void validatelogin() {

		lgnpg = PageFactory.initElements(driver, LoginPage.class);
		driver.switchTo().window(driver.getWindowHandle());
		homepage = lgnpg.Login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
