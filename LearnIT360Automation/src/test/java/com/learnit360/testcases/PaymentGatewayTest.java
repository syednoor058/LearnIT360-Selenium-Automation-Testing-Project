package com.learnit360.testcases;

import org.testng.annotations.Test;

import com.learnit360.pages.BaseTest;
import com.learnit360.pages.DashboardPage;
import com.learnit360.pages.LoginPage;
import com.learnit360.pages.PaymentPage;
import com.learnit360.utilities.ReadExcelFile;

public class PaymentGatewayTest extends BaseTest {
	
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";

	@Test
	public void paymentcheckingTest() throws InterruptedException {
		String username = "Demo12";
		String password = "Test123456$";
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPortal(username, password);
		
		DashboardPage dp = new DashboardPage(driver);
		dp.subscribeToCourse();
		
		PaymentPage pp = new PaymentPage(driver);
		String cardNumber = ReadExcelFile.getCellValue(fileName, "CardInfo", 0, 0);
		String cardExpDate = ReadExcelFile.getCellValue(fileName, "CardInfo", 0, 1);
		String cardCVC = Integer.toString(ReadExcelFile.getNumericCellValue(fileName, "CardInfo", 0, 2));

		pp.paymentOption(cardNumber, cardExpDate, cardCVC);
		
		Thread.sleep(3000);
	}
}
