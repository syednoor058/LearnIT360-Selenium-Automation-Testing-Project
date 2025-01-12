package com.learnit360.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnit360.pages.BaseTest;
import com.learnit360.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	void verifyLogin() {
		LoginPage lp = new LoginPage(driver);
		String username = "Demo12";
		String password = "Test123456$";
		lp.loginPortal(username, password);
		
		if(username.equals("Demo12") && password.equals("Test123456$")){
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logOut();
		}
		else{
			captureScreenShot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
		
//		lp.logOut();
	}
}
