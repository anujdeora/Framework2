package com.app.testcases;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
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
import com.app.pages.OneNeuronPage;
import com.app.pages.ProfilePage;
import com.app.utils.TestUtil;

public class ProfilePageTest extends TestBase {

	
	public ProfilePageTest() {
		
		super();
	}
	
	LoginPage lgnpg;
	HomePage homepage;
	TestUtil testutil;
	OneNeuronPage ONPage;
	ProfilePage prflpg;
	
	@BeforeClass
	public void SetUp() {
		BrowserInitialization();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		lgnpg = new LoginPage();
		lgnpg = PageFactory.initElements(driver, LoginPage.class);		
		lgnpg.clicklogin();
		testutil = new TestUtil();
		testutil.switchHandles();
		homepage=lgnpg.Login(prop.getProperty("username"), prop.getProperty("password"));	
		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.clickOnProfile();
	}
	
	
	@Test
	public void verifyProfilePageTitle() {
		
		prflpg=PageFactory.initElements(driver, ProfilePage.class);
		String profilePageTitle=prflpg.getProfilePageTitle();
		Assert.assertEquals("Profile | iNeuron.ai", profilePageTitle);
	}
	
	
	@AfterClass
		public void teardown() {
			driver.quit();
		}
	
	
}
