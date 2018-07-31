/*package com.report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report2 {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void testSetUp() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
	extent= new ExtentReports("./Reports/my report.html",true);   //Report initializing
	extent.addSystemInfo("Product Version", "3.0.0")   //System or environment info
	.addSystemInfo("Author", "Sachin Kadam");
	}
	@Test
	public void TC1() {
	test = extent
	.startTest("Test case 1", "Check the google home page title")  //Start test case
	.assignAuthor("Sachin Kadam")
	.assignCategory("Regression", "Functional");
	String appURL = "http://google.com";
	driver.get(appURL);
	test.log(LogStatus.INFO, "Navigating to URL : "+appURL);   //Log info
	customVerify(driver.getTitle(), "Google");
	extent.endTest(test);   //End test case
	checkForErrors();
	}
	@Test
	public void TC2() {
	test = extent
	.startTest("Test case 2", "Check the wikipedia home page title") //Start test case
	.assignCategory("Functional")
	.assignAuthor("Sachin Kadam");
	String appURL = "https://www.wikipedia.org";
	driver.get(appURL);
	test.log(LogStatus.INFO, "Navigating to URL : "+appURL); //Log info
	customVerify(driver.getTitle(), "Google"); //Incorrect expected title to fail test case
	extent.endTest(test);   //End test case
	checkForErrors();
	}
	//custom assertion method for string comparison
	public void customVerify(String actual, String expected){
	try{
	Assert.assertEquals(actual, expected);
	//Log pass results
	test.log(LogStatus.PASS, "Expected title:"+expected + " :: Current title:" + actual);
	}catch(Error e){
	//Log fail results along with error
	test.log(LogStatus.FAIL, "Expected title:"+expected + " :: Current title:" + actual +" :: "+ e.toString());
	verificationErrors.append(e);
	}
	}
	@AfterTest
	public void tearDown(){
	driver.quit();
	extent.flush();
	}
	//Method for logging correct results to TestNG report in case of failure
	public void checkForErrors(){
	if(!"".equals(verificationErrors.toString())){
	Assert.fail(verificationErrors.toString());
	verificationErrors = new StringBuffer();
	}
	}
	}
	
}
*/