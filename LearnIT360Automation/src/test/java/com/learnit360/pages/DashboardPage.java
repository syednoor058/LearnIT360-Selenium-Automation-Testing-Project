package com.learnit360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/nav[2]/ul[1]/li[1]/a[1]") WebElement dashboardIcon;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]") WebElement offeredAcademies;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/form[1]/div[1]/button[1]") WebElement subscribeCourse;
	
	public void subscribeToCourse() {
		dashboardIcon.click();
		offeredAcademies.click();
		subscribeCourse.click();
		
	}
}
