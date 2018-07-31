package com.usa.ttech.practicecode;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WindowHandleInSelenium {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
        //Launching the site.				
       driver.get("http://demo.guru99.com/popup.php");			
        driver.manage().window().maximize();		
                		
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
        		
        String MainWindow=driver.getWindowHandle();		
        		
        // To handle all new opened window.				
            Set<String> allwindows=driver.getWindowHandles();		
        Iterator<String> get_each_page=allwindows.iterator();		
        		
        while(get_each_page.hasNext())			
        {		
        	TimeUnit.SECONDS.sleep(2);
            String ChildWindow=get_each_page.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
            	TimeUnit.SECONDS.sleep(2);
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);		
                                                                                         
                    TimeUnit.SECONDS.sleep(2);                                                                        
                       
                    // write all code here for new page
                    
                    
                       TimeUnit.SECONDS.sleep(10);    
			// Closing the Child Window.
                        driver.close();		
            }		
        }		
        TimeUnit.SECONDS.sleep(10);
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);		
            
         
          
         }
         }     
            
  
