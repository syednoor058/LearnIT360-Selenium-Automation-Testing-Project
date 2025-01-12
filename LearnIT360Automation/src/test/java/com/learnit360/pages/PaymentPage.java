package com.learnit360.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="/html[1]/body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ul[1]/li[1]/label[1]") WebElement stripeRadioBtn;
	@FindBy (xpath="//*[@id=\"learn-press-checkout-place-order\"]") WebElement placeOrderBtn;
	@FindBy (xpath="//*[@id=\"smform\"]/fieldset/div[1]/input") WebElement paymentEmail;
	@FindBy (xpath="//*[@id=\"card-element\"]/div/iframe") WebElement iFrameElement;
	@FindBy (xpath="//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input") WebElement cardNumEle;
	@FindBy (xpath="//*[@id=\"root\"]/form/div/div[2]/span[2]/span[1]/span/span/input") WebElement cardExpDateEle;
	@FindBy (xpath="//*[@id=\"root\"]/form/div/div[2]/span[2]/span[2]/span/span/input") WebElement cardCVCEle;
	@FindBy (xpath="//*[@id=\"payment-button\"]") WebElement payNowBtn;
	 
	public void paymentOption(String cardNumber, String cardExpDate, String cardCVC) {
		stripeRadioBtn.click();
		placeOrderBtn.submit();
		paymentEmail.clear();
		paymentEmail.sendKeys("syednoor058@gmail.com");
		
		driver.switchTo().frame(iFrameElement);
		cardNumEle.sendKeys(cardNumber);
		cardExpDateEle.sendKeys(cardExpDate);
		cardCVCEle.sendKeys(cardCVC);
		driver.switchTo().defaultContent();
		
		payNowBtn.click();
	}
}
