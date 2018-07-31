package com.testing;

import org.openqa.selenium.WebDriver;

public class variabletesting {

	static WebDriver driver;

	
	 variabletesting(WebDriver driver){
		this.driver=driver;
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(driver);
		
		
		variabletesting obj = new variabletesting(driver);
		System.out.println(driver);
		
	}

}
