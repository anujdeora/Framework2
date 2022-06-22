package com.app.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.base.TestBase;

public class OneNeuronPage extends TestBase {

	
	@FindBy(xpath="//span[contains(text(),'All the Neurons')]")
	WebElement AlltheNeurons;
	
	public void OneNeuronPage() {
		
		PageFactory.initElements(driver, TestBase.class);
		
	}
	
	
	public boolean getOneNeuronHeading() {
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(AlltheNeurons));
		return AlltheNeurons.isDisplayed();
	}
	
}
