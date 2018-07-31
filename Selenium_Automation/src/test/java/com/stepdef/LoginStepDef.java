/*package com.stepdef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.LoginPageFactory;
import com.util.HighLighter;
import com.util.TakeScreenShot;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	WebDriver driver;
	LoginPageFactory pf;
	
	
	
	
	@Given("^User able to open any browser$")
	public void user_able_to_open_any_browser() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		
	}

	@Given("^Put URL and go to login page$")
	public void put_URL_and_go_to_login_page() throws Throwable {
		driver.get("http://www.gcrit.com/build3/");
		pf=PageFactory.initElements(driver, LoginPageFactory.class);
	
	    
	}
	@When("^User able to click my account$")
	public void user_able_to_click_my_account() throws Throwable {
	
		pf.getMyAccountloginBtn().click();
	    
	}

	@When("^Validate as its login page$")
	public void validate_as_its_login_page() throws Throwable {
	
		String loginPageTitle= pf.getLoginPageTitle().getText();
		HighLighter.getDrawRedColor(driver, pf.getLoginPageTitle());
		System.out.println(loginPageTitle);
		 Thread.sleep(1500);
	}
	@When("^User able to use valid <user_name>$")
	public void user_able_to_use_valid_user_name(DataTable userName) throws Throwable {
		List<List<String>> name=userName.raw();
		pf.getUserName().sendKeys(name.get(1).get(0));
		HighLighter.getDrawRedColor(driver, pf.getUserName());
		Thread.sleep(1500);
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    
	}

	@When("^User able to put valid <password>$")
	public void user_able_to_put_valid_password(DataTable password) throws Throwable {
	    
		List<List<String>> pass=password.raw();
		pf.getPassword().sendKeys(pass.get(1).get(0));
		HighLighter.getDrawRedColor(driver, pf.getPassword());
		Thread.sleep(1500);
	}



	
	
	@When("^User able to take screen Shot of login page$")
	public void user_able_to_take_screen_Shot_of_login_page() throws Throwable {
		TakeScreenShot.captureScreenShot(driver, "login page");
	    
	}

	@When("^User able to click submit button$")
	public void user_able_to_click_submit_button() throws Throwable {
	  Thread.sleep(4000);
		HighLighter.getDrawRedColor(driver, pf.getSignInbtn());
		pf.getSignInbtn().click();
	    
	}

	@Then("^User able to validate Login status$")
	public void user_able_to_validate_Login_status() throws Throwable {
	    
		if(pf.getLoginSuccessTitle().getSize().getHeight()>0) {
			HighLighter.getDrawRedColor(driver, pf.getLoginSuccessTitle());
			System.err.println("Login success ::"+ pf.getLoginSuccessTitle().getText());
			Thread.sleep(1500);
		}
		else if (pf.getLoginFailTitle().getSize().getHeight()>0) {
			HighLighter.getDrawRedColor(driver, pf.getLoginFailTitle());
			System.err.println("Login failed ::"+ pf.getLoginFailTitle().getText());
			Thread.sleep(1500);
		}
		else {
			System.out.println("Something wrong in login>>>> check screen shot");
		}
	    
	}

	@Then("^User able to take screen Shot of home page$")
	public void user_able_to_take_screen_Shot_of_home_page() throws Throwable {
		TakeScreenShot.captureScreenShot(driver, "Home page");
	    
	}
	
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    
		driver.quit();
	    
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
*/