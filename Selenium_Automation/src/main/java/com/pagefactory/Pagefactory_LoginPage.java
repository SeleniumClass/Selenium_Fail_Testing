package com.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_LoginPage {
	
	WebDriver driver;
	
	 public Pagefactory_LoginPage(WebDriver driver){
		this.driver= driver;
		 
	}
	
	

	
	 @FindBy(how = How.XPATH, using = "//*[contains(text(),'Sign In or Create Account')]")
	 private WebElement signInbtn;
	 
	 @FindBy(how = How.XPATH, using = "//*[@id='loginPageUsername']")
		private WebElement userName;
	
	 @FindBy(how = How.XPATH, using = "//*[@id='loginPagePassword']")
		private WebElement passwrod;
	
	 @FindBy(how = How.XPATH, using = "//*[@class='buttonText']")
		private WebElement submitbtn;

	public WebElement getSignInbtn() {
		return signInbtn;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPasswrod() {
		return passwrod;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	
	
	
	
	
	
	
	



	
}
