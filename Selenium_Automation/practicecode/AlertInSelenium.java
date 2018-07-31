package com.usa.ttech.practicecode;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class AlertInSelenium {

	static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox-sdk\\bin\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);

		driver.get("http://demo.guru99.com/selenium/delete_customer.php");
	TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath("//*[@name='cusid']")).sendKeys("123456");
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath("//*[@name='submit']")).click();
		TimeUnit.SECONDS.sleep(5);
		Alert alert=driver.switchTo().alert();
		TimeUnit.SECONDS.sleep(2);
		System.out.println(alert.getText());
		TimeUnit.SECONDS.sleep(2);
		alert.accept();
		//alert.dismiss();
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
