package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.report.BaseTest;



public class TestClass2 extends BaseTest{
 WebDriver driver;
	@Test
	public void testtest() {
		//test= extent.createTest("TestClass2.test1");
		test.log(Status.INFO, "This is simple test Two");
		//Assert.assertEquals("sarower", "sarower");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://www.gcrit.com/build3/");
	}
	
}
