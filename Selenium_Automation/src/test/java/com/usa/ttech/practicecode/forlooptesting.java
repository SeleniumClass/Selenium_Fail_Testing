package com.usa.ttech.practicecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class forlooptesting {

	static WebDriver driver;
	public static void main(String[] args) {
	
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		WebDriverWait wait= new WebDriverWait(driver,60);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
		
		
		
	}
}
