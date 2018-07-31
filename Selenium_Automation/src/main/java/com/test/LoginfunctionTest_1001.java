package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.util.HighLighter;


public class LoginfunctionTest_1001 {
	WebDriver driver;
	@Test
	public void login_1001()throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://www.gcrit.com/build3/");

		WebElement myaccountbtn = driver.findElement(By.xpath("//*[contains(text(),'My Account')]"));
		HighLighter.getDrawBlueYellow(driver, myaccountbtn);
		myaccountbtn.click();
		Thread.sleep(3000);

		WebElement loginpageTitle = driver.findElement(By.xpath("//*[contains(text(),'Welcome, Please Sign In')]"));
		HighLighter.getDrawRedColor(driver, loginpageTitle);

		if (loginpageTitle.getText().equalsIgnoreCase("Welcome, Please Sign In")) {
			System.out.println("Got the login page::" + loginpageTitle.getText());
		} else {
			System.out.println("Test Failed>>>> Page Title::" + loginpageTitle.getText());
		}

		WebElement email = driver.findElement(By.xpath("(//*[contains(text(),'')]//following::input)[2]"));
	
		
		
		
		
		email.sendKeys("sarowerny@gmail.com");
		HighLighter.getDrawBlueColor(driver, email);
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("(//*[contains(text(),'')]//following::input)[3]"));
		password.sendKeys("student ");
		HighLighter.getDrawBlueColor(driver, email);
		Thread.sleep(3000);
		WebElement loginbtn = driver.findElement(By.xpath("//*[starts-with(text(),'Sign In')]"));
		HighLighter.getDrawRedColor(driver, email);
		loginbtn.click();
		Thread.sleep(4000);
		
		WebElement myaccountPage = driver.findElement(By.xpath("//*[contains(text(),'My Account Information')]"));
		HighLighter.getDrawRedColor(driver, myaccountPage);

		if (myaccountPage.getText().equalsIgnoreCase("My Account Information")) {
			System.out.println("Got the My Account Page::" + myaccountPage.getText());
		} else {
			System.out.println("Test Failed>>>> Page Title::" + myaccountPage.getText());
		}
		
		

		// validation
		Assert.assertEquals("GCR Shop", driver.getTitle(), "Test Passed");
		// verification

		if (driver.getTitle().equalsIgnoreCase("GCR Shop")) {
			System.out.println("Test Passed>>>> Page Title::" + driver.getTitle());
		} 
		
		
		else {
			System.out.println("Test Failed>>>> Page Title::" + driver.getTitle());
		}

Thread.sleep(1500);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		WebElement catalog = driver.findElement(By.xpath("//*[contains(text(),'Catalog')]"));
		HighLighter.getDrawBlueColor(driver, catalog);
		catalog.click();

		Thread.sleep(1500);
		WebElement newProduct = driver.findElement(By.xpath("//*[contains(text(),'new products')]"));
		HighLighter.getDrawBlueColor(driver, newProduct);
		newProduct.click();
		Thread.sleep(1500);
		List<WebElement> allProduct = driver
				.findElements(By.xpath("//*[@class='contentContainer']//*[contains(@src,'images/')]"));

		Thread.sleep(1500);
		List<WebElement> pageNumber = driver.findElements(By.xpath("//*[contains(@class, 'pageResults')]"));
		
		System.out.println("Page number count::" + pageNumber.size());
		Actions ac = new Actions(driver);

	ArrayList<String> allproductName=new ArrayList<String> ();
		for (int i = 1; i < pageNumber.size(); i++) {
			pageNumber=driver.findElements(By.xpath("//*[contains(@class, 'pageResults')]"));
			ac.moveToElement(pageNumber.get(i)).click().perform();
		
			Thread.sleep(2000);
			System.out.println("");
			System.err.println("Total product on " + i + " page:::" + allProduct.size());
			System.out.println("========================================================");
			for (int j = 0; j < allProduct.size(); j++) {

				allProduct = driver
						.findElements(By.xpath("//*[@class='contentContainer']//*[contains(@src,'images/')]"));

				try {
			
					if (allProduct.get(j).getSize().getHeight() > 0) {

						new WebDriverWait(driver, 180).until(ExpectedConditions.numberOfElementsToBeMoreThan(
								By.xpath("//*[@class='contentContainer']//*[contains(@src,'images/')]"), 0));
						ac.moveToElement(allProduct.get(j)).build().perform();
						HighLighter.getDrawBlueColor(driver, allProduct.get(j));
						System.out.println("-----------------------------------------------------------");
						System.out.println("Product Name :::" + allProduct.get(j).getAttribute("title"));
						System.out.println("-----------------------------------------------------------");
						allproductName.add(allProduct.get(j).getAttribute("title"));
						

					}
				} catch (Exception e) {
					System.err.println(">>>not found product name");

				}
			}

			
			if (i==6) {
				break;
			}
		}
		System.out.println("");
		System.out.println("======================================================================");
		System.out.println("All products Name list::"+allproductName);
		System.out.println("======================================================================");
		System.out.println("");
		
		Map<String, Long> counts =
				allproductName.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println("=======================================================================");
		System.out.println("Products frequency count::"+counts);
		System.out.println("=======================================================================");
		
		List<String> matches = allproductName.stream().filter(it -> it.contains("Laptop")).collect(Collectors.toList());

		
		System.out.println(matches+"  got it and will buy");
		
		driver.quit();
		

	}

}
