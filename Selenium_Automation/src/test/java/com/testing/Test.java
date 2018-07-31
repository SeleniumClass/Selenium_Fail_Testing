package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
 
	public static void main(String[] args) throws Throwable {
		
		   System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		
			driver.manage().window().maximize();
			driver.get("http://www.gcrit.com/build3/");
		
			WebElement myaccountbtn=driver.findElement(By.xpath("//*[@id='tdb3']/span[2]"));
			
			
			 JavascriptExecutor object = (JavascriptExecutor) driver;
			 object.executeScript("arguments[0].style.border='3px solid green'", myaccountbtn);
			 Thread.sleep(2000);
	
			myaccountbtn.click();
			
			
			WebElement email=driver.findElement(By.xpath("(//*[@type='text'])[1]"));
			email.sendKeys("sarowerny@gmail.com");
			
			WebElement password=driver.findElement(By.xpath("(//*[@type='password'])[1]"));
			password.sendKeys("student ");
			WebElement loginbtn=driver.findElement(By.xpath("(//*[@class='ui-button-text'])[5]"));
			loginbtn.click();
			
	}
 
}
