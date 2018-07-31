package com.usa.ttech.practicecode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {

	public static void drawBorder(WebDriver driver, String xpath){
        WebElement element_node = driver.findElement(By.xpath(xpath));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid green'", element_node);
    }
	public static void drawBorder(WebDriver driver, WebElement webelement){
        WebElement element_node = webelement;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid green'", element_node);
    }
	
}