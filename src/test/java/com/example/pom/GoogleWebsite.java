package com.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.pom.pages.SearchPage;

public class GoogleWebsite {
	
	@FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
	private WebElement searchBar;
	
	public SearchPage searchPage;
	
	public GoogleWebsite(WebDriver driver) {
		this.searchPage = PageFactory.initElements(driver, SearchPage.class);
	}
	
	public void search(String term) {
		searchBar.sendKeys(term);
		searchBar.submit();
	}
}
