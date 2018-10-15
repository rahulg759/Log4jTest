package com.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;
	Logger log = Logger.getLogger(Login.class);

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\My_Workspace\\basic\\CucumberDemoWithFreeCRM\\executable\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/");

	
	}

	@Test(priority = 0)
	public void testCRMTitle() {
		String title = driver.getTitle();
		String expectedTitle = "#1 Free CRM software in the cloud for sales and service";
		Assert.assertEquals(title, expectedTitle);
	}

	@Test(priority = 1)
	public void CRMLogo() {
		driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
