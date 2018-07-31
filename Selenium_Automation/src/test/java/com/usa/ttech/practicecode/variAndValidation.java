package com.usa.ttech.practicecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class variAndValidation {
static WebDriver driver;
	public static void main(String[] args) {
		
		 driver= new FirefoxDriver();
		  driver.get("https://www.UPS.com/");
		 if(driver.getTitle().equalsIgnoreCase("UPS home page")) {
			   System.out.println("Test Passed");
		   }
		   else {
			   System.out.println("Test Failed");
		   }
		   
		 Assert.assertEquals( driver.getTitle(), "UPS home page");
		   
		   System.out.println("HELLO JAVA");

	}

}
