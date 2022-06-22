package com.app.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.app.base.TestBase;

public class TestUtil extends TestBase {

	
public void TestUtil() {
		
		PageFactory.initElements(driver, TestBase.class);
	}
	
	
	public void switchToFrame() {
		
		driver.switchTo().frame("");
	}
	
	public void takeScreenshots() {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshots/SS.PNG"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	public void switchHandles() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}


	private void scrolldown() {
		
		Actions act1 = new Actions(driver);
		act1.moveByOffset(500, 500).build().perform();
		
	}
	
}
