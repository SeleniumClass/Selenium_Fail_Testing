package com.test;

import org.openqa.selenium.WebDriver;

public class Child {

	
	 static WebDriver driver;

	 Child(WebDriver driver){
		this.driver= driver; 
	 }
	
	public static void main(String[] args) {
	
		
		
		System.out.println(driver);
	}

}