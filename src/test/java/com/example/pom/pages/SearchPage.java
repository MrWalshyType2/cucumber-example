package com.example.pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	
	@FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div/div[2]/input")
	WebElement searchBar;

	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement results;
	
	public String findSiteInResults(String expectedUrl) {
		List<WebElement> searchResultNames = results.findElements(By.tagName("a"));
		
		for (WebElement we : searchResultNames) {
			if (we.getAttribute("href").contains(expectedUrl)) {
				return we.getAttribute("href");
			}
		}
		return "Not found a viable result";
	}
	
	public String getSearchBarText() {
		return searchBar.getAttribute("value");
	}
}
