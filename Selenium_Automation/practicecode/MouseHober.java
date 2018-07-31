package com.usa.ttech.practicecode;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import com.util.helper.HighlightEmenet;

public class MouseHober {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.com/");

		WebElement element = driver.findElement(By.xpath(".//*[@id='nav-link-accountList']/span[2]"));
		HighlightEmenet.drawBorder(driver, element);
		Thread.sleep(2500);
		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

		driver.findElement(By.xpath(".//*[@id='nav-al-wishlist']/a[3]/span")).click();

	}

}
