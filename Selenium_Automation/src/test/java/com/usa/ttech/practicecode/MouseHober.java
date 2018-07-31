package com.usa.ttech.practicecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.internal.Systematiser;

public class MouseHober {

	static String name;
	public static void main(String[] args) throws Exception {
	
	System.out.println(name);
	
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.com/");

		WebElement element = driver.findElement(By.xpath(".//*[@id='nav-link-accountList']/span[2]"));
		HighlightElement.drawBorder(driver, element);
		Thread.sleep(2500);
		Actions action = new Actions(driver);

		action.moveToElement(element).clickAndHold(element).build().perform();

		driver.findElement(By.xpath(".//*[@id='nav-al-wishlist']/a[3]/span")).click();

	}

}
