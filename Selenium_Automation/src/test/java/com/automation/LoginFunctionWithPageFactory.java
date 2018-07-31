package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pagefactory.LoginPageFactory;
import com.report.BaseTest;
import com.util.HighLighter;
import com.util.TakeScreenShot;

public class LoginFunctionWithPageFactory extends BaseTest{

	static WebDriver driver;

	@BeforeTest
	public void setup() {
		test= extent.createTest("Before test");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://www.gcrit.com/build3/");
	}

	@Test
	public void logintest() throws Throwable {
		test= extent.createTest(" test");
		LoginPageFactory pf = PageFactory.initElements(driver, LoginPageFactory.class);

		pf.getMyAccountloginBtn().click();

		pf.getMyAccountloginBtn().click();

		String loginPageTitle = pf.getLoginPageTitle().getText();
		System.out.println(loginPageTitle);

		pf.getUserName().sendKeys("your name");

		pf.getPassword().sendKeys("your pass");

		pf.getSignInbtn().click();

		if (pf.getLoginSuccessTitle().getSize().getHeight() > 0) {
			HighLighter.getDrawRedColor(driver, pf.getLoginSuccessTitle());
			System.err.println("Login success ::" + pf.getLoginSuccessTitle().getText());

		} else if (pf.getLoginFailTitle().getSize().getHeight() > 0) {
			HighLighter.getDrawRedColor(driver, pf.getLoginFailTitle());
			System.err.println("Login failed ::" + pf.getLoginFailTitle().getText());

		} else {
			System.out.println("Something wrong in login>>>> check screen shot");
		}
		TakeScreenShot.captureScreenShot(driver, "Home page");

	}

	
	
	@Test 
	public void getproduct() {
		
		
	}
	
	
	@AfterTest
	public void teardown() {
		test= extent.createTest("After test");
		driver.quit();
	}

}
