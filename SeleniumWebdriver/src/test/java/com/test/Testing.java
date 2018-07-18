package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testing {
	@Parameters("browser")
	@Test
	public void testLogin(String value)
	{
		WebDriver driver=null;
		if(value.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(value.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("No Driver found");
		}
		driver.get("https://github.com/login");
		driver.findElement(By.id("login_field")).sendKeys("abinaya");
		driver.findElement(By.id("password")).sendKeys("Testing1234");
		driver.findElement(By.name("commit")).click();
		String title=driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Sign in to GitHub · GitHub");
		
		System.out.println("Success - Output Veri");
	}
	}

