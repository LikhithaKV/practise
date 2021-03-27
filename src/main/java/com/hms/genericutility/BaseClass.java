package com.hms.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	@BeforeSuite
	public void dbConnectivity() {
		
	}
	
	@Parameters("browser")
	
	@BeforeClass
	public void launchBrowser(@Optional("chrome")String browser) {
	
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	}
	
		else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
	}
		
		else  {
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		}
	}
	
	@BeforeMethod
	public void loginToApp() {
}
	@AfterMethod
	public void logoutFromApp() {
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void closeDb() {
}
}