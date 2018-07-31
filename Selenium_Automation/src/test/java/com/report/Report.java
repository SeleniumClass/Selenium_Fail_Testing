package com.report;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pagefactory.LoginPageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.util.HighLighter;
import com.util.TakeScreenShot;

public class Report {

	 WebDriver driver;
	 ExtentReports report;
	 ExtentTest test;
	 
	 @BeforeSuite
	 public void beforesuit() {
		
	 }
	@BeforeTest
	public void setup(Method method) {
		 report= new ExtentReports("./Reports/my report.html",true);
			report.loadConfig(new File("./extends_cofig.xml"));
		test= report.startTest((this.getClass().getSimpleName()+"::"+ method.getName()),method.getName());
		test.assignAuthor("sarower");
		test.assignCategory("smoke");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.PASS, "Browser opened");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://www.gcrit.com/build3/");
		test.log(LogStatus.PASS, "Application opened");
		
	}

	@Test
	public void logintest() throws Throwable {

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
			test.log(LogStatus.PASS, "Login Passed");
		} else if (pf.getLoginFailTitle().getSize().getHeight() > 0) {
			HighLighter.getDrawRedColor(driver, pf.getLoginFailTitle());
			System.err.println("Login failed ::" + pf.getLoginFailTitle().getText());
			test.log(LogStatus.FAIL, "Login Failed");
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

		driver.quit();
		test.log(LogStatus.PASS, "Browser closed");
		report.flush();
		report.close();
	}
@AfterSuite
public void afterSuit() {

	
}
}