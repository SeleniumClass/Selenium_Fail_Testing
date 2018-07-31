package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPageFactory {
	WebDriver driver;

	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
		// This initElements method will create all WebElements
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 200);
		//PageFactory.initElements( driver,factory);
	}
	
	
	
	
	
	
	/**
	 * @author sarower
	 *
	 */
	
	

	// Login function xpath
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'My Account')]")
	private WebElement myAccountloginBtn;
	
	
	@FindBy(how = How.XPATH, using = "//*[@name='email_address']")
	private WebElement UserName;

	@FindBy(how = How.XPATH, using = "//*[@name='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Sign In')])[2]")
	private WebElement signInbtn;

	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Sign In')])[1]")
	private WebElement loginPageTitle;
	
	@FindBy(how = How.XPATH, using = "(//*[@class='contentText'])[1]")
	private WebElement loginSuccessTitle;
	
	@FindBy(how = How.XPATH, using = "//*[@class='messageStackError']")
	private WebElement loginFailTitle;

// product list xpath


	// ALL getter methods
	
	public WebElement getMyAccountloginBtn() {
		return myAccountloginBtn;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInbtn() {
		return signInbtn;
	}

	public WebElement getLoginPageTitle() {
		return loginPageTitle;
	}

	public WebElement getLoginSuccessTitle() {
		return loginSuccessTitle;
	}

	public WebElement getLoginFailTitle() {
		return loginFailTitle;
	}
	
	
	
	
	
	
	
	
}
	
	
	