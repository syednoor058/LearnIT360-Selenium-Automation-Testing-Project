package com.learnit360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginlabel") WebElement loginButton;
	@FindBy(id="user_login") WebElement usernameField;
	@FindBy(id="user_pass") WebElement passwordField;
	@FindBy(id="wp-submit") WebElement submitButton;
	@FindBy(xpath="(//i[@class='fa fa-user'])[1]") WebElement userSign;
	@FindBy(xpath="(//a[contains(text(),'Logout')])[1]") WebElement logoutButton;
	
	public void loginPortal (String username, String password) {
		
		if(loginButton.isDisplayed()) {
			loginButton.click();
			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			submitButton.click();
		}
		
	}
	
	public void logOut() {
		userSign.click();
		logoutButton.click();
	}
}
