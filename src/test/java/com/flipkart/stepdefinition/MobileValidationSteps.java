package com.flipkart.stepdefinition;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class MobileValidationSteps {
	static WebDriver driver;
	static long startTime;
	static String name;
	
	
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Given("user login by entering valid crendentials")
	public void user_login_by_entering_valid_crendentials() {
	  
		try
		{
			WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
			close.click();
		}
		catch(Exception e)
		{
			
		}
	}

	@When("user search mobile")
	public void user_search_mobile() {
	    
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys("vivo",Keys.ENTER);
		
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
	  
		WebElement mobilename = driver.findElement(By.xpath("//div[text()='vivo T1 5G (Starlight Black, 128 GB)']"));
		name = mobilename.getText();
		System.out.println(name);
		mobilename.click();
		
	}

	@Then("user validate the mobile names")
	public void user_validate_the_mobile_names() {
	    String parent = driver.getWindowHandle();
	    Set<String> children = driver.getWindowHandles();
	    for(String x : children) {
	    	if(!parent.equals(x)) {
	    		driver.switchTo().window(x);
	    	}
	    }
	    
	   // WebElement mobilename2 = driver.findElement(By.xpath("//span[text()='vivo T1 5G (Starlight Black, 128 GB)']"));
	   // Assert.assertTrue(mobilename2.isDisplayed());
	    // String name2 = mobilename2.getText();
	     //System.out.println(name2);
	     
	    // assert.assertEquals(name, name2);
	    
	  
	}



}
