package com.app.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		File src = new File("D:\\Eclipse\\Framework2\\src\\main\\java\\com\\app\\config\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
			}
		} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());			
		}
	}

	public static void BrowserInitialization() {
		
	String BrowserName =prop.getProperty("browser");
		if(BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			}
			else if(BrowserName.equals("FireFox")) {
				
				System.setProperty("webdriver.chrome.driver","./Drivers/geckodriver.exe");
				driver=new FirefoxDriver();				
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
}
