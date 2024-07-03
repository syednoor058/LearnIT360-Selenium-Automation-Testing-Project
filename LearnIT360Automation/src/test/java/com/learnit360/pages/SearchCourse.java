package com.learnit360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SearchCourse {
	
	WebDriver driver;

	public SearchCourse(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_course") WebElement searchBox;
	@FindBy(xpath="/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/form[1]/button[1]") WebElement searchIcon;
	
	public void searchForCourse(String courseName) {
		searchBox.sendKeys(courseName);
		searchIcon.click();
	}
}
