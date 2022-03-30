package com.flipkart.stepdefinition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
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
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class MobileValidationSteps {
	static WebDriver driver;
	static long startTime;
	static String name;
	static String mn;
	
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
	  
	

			WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
			close.click();

			
	
	}

	@When("user search mobile")
	public void user_search_mobile() {
		
	    mn = "vivo";
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);
		
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
	  
		WebElement mobilename = driver.findElement(By.xpath("//div[text()='"+mn+"']"));
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
	    
	  
	}
	@When("user search mobile by one dim list")
	public void user_search_mobile_by_one_dim_list(DataTable datatable) {
		List<String> datas = datatable.asList();
		mn = datas.get(1);
		
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);
}
	@When("user search mobile by one dim map")
	public void user_search_mobile_by_one_dim_map(DataTable datatable) {
		Map<String, String> datas = datatable.asMap(String.class, String.class);
		
		mn = datas.get("3");
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);


}
	@When("user search mobile {string}")
	public void user_search_mobile(String phone) {
		
		mn=phone;
		
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);


	}
}
