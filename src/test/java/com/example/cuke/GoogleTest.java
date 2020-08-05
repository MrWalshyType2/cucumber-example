package com.example.cuke;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.example.pom.GoogleWebsite;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleTest {
	
	WebDriver driver;
	
	GoogleWebsite website;
	
	String url = "https://www.google.com/";
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\morga\\OneDrive\\Documents\\QA\\cucumber-example\\src\\test\\resources\\drivers\\chromedriver84.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true); // turns off browser display during tests
		driver = new ChromeDriver(chromeOptions);
		this.website = PageFactory.initElements(driver, GoogleWebsite.class);
	}

	// @Given, @When, @Then compile into one test
	@Given("^I want to search in Google$")
	public void i_want_to_search_in_Google() throws Throwable {
		driver.get(url);
		
		assertEquals(url, driver.getCurrentUrl());
	    //throw new PendingException();
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		// arg1 is passed from googleTest.feature | -> when I search for "Pokemon"		
		this.website.search(arg1);
		
		Thread.sleep(2000);

		assertEquals(arg1, this.website.searchPage.getSearchBarText());
	    //throw new PendingException();
	}

	@Then("^I should see a link to \"([^\"]*)\"$")
	public void i_should_see_a_link_to(String arg1) throws Throwable {		
		String expectedUrl = arg1;
		String actualUrl = this.website.searchPage.findSiteInResults(expectedUrl);
		
		assertEquals(expectedUrl, actualUrl);
	}
	
	@After
	public void shutdown() {
		driver.quit();
	}
}
