package com.stepdef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.Pagefactory_LoginPage;
import com.util.TakeScreenShot;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public final class LoginTest {

	 WebDriver driver;
	 Pagefactory_LoginPage pf;
	 
	 // run = feature or  runner file= TestNG/Junit or maven
	


	 
	 
	@Given("^User able to open any browser$")
	public void user_able_to_open_any_browser() throws Throwable {
		
		 System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		  driver = new ChromeDriver();		
		  
	}
	
	
	@Given("^Put URL and go to login page$")
	public void put_URL_and_go_to_login_page() throws Throwable {
	    driver.get("https://disneyworld.disney.go.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	    pf= PageFactory.initElements(driver, Pagefactory_LoginPage.class);
		  
	    String pagetitle= driver.getTitle();
	    
	    System.out.println(pagetitle);
	    
	    if (pagetitle.contains("Walt Disney World")) {
	    	
	    	System.out.println("Got Disney home page");
	    	TakeScreenShot.captureScreenShot(driver, "Disney home page");
	    	
	    }
	    else {
	    	System.out.println("Something went wrong and check screen shot");
	    	
	    	TakeScreenShot.captureScreenShot(driver, "Disney home page");
	    }
	    
	}

	@When("^User able to click my account$")
	public void user_able_to_click_my_account() throws Throwable {
	      
	    pf.getSignInbtn().click();
	}

	@When("^Validate as its login page$")
	public void validate_as_its_login_page() throws Throwable {
	    
	    String loginPage = driver.getTitle();
   System.out.println(loginPage);
	    if (loginPage.contains("ddddddd")) {
	    	
	    	System.out.println("login page");
	    	TakeScreenShot.captureScreenShot(driver, "Login Page");
	    	
	    }
	    else {
	    	System.out.println("Something went wrong and check screen shot");
	    	
	    	TakeScreenShot.captureScreenShot(driver, "Login page");
	    }
	    
	    
	}

	@When("^User able to take screen Shot of login page$")
	public void user_able_to_take_screen_Shot_of_login_page() throws Throwable {
	    
		TakeScreenShot.captureScreenShot(driver, "Login page2");
	}

	@When("^User able to use valid <user_name>$")
	public void user_able_to_use_valid_user_name(DataTable userName) throws Throwable {
	
	    
		List<List<String>> obj =userName.raw();
		
		pf.getUserName().sendKeys(obj.get(1).get(0));
	}

	@When("^User able to put valid <password>$")
	public void user_able_to_put_valid_password(DataTable password) throws Throwable {
	   
		List<List<String>> mypassword =password.raw();
		pf.getPasswrod().sendKeys(mypassword.get(1).get(0));
	    
	}

	@When("^User able to click submit button$")
	public void user_able_to_click_submit_button() throws Throwable {
	  
	  pf.getSubmitbtn().click();
	    
	}

/*	@Then("^User able to validate Login status$")
	public void user_able_to_validate_Login_status() throws Throwable {
	   String homepageTitle=driver.getTitle();
	   System.out.println(homepageTitle);
	    if (homepageTitle.contains("ddddddd")) {
	    	
	    	System.out.println("login page");
	    	TakeScreenShot.captureScreenShot(driver, "Login Page");
	    	
	    }
	    else {
	    	System.out.println("Something went wrong and check screen shot");
	    	
	    	TakeScreenShot.captureScreenShot(driver, "Login page");
	    }
	}*/

	@Then("^User able to take screen Shot of home page$")
	public void user_able_to_take_screen_Shot_of_home_page() throws Throwable {
		TakeScreenShot.captureScreenShot(driver, "HomePage");
	    
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	
		driver.quit();//=== browser + driver
	    
	}


	
	
	

}
