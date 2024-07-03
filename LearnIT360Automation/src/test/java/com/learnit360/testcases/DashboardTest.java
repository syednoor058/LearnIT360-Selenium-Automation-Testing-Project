package com.learnit360.testcases;

import org.testng.annotations.Test;

import com.learnit360.pages.BaseTest;
import com.learnit360.pages.DashboardPage;
import com.learnit360.pages.LoginPage;

public class DashboardTest extends BaseTest {

	@Test
	public void subdcribeToCourseTest() {
		String username = "Demo12";
		String password = "Test123456$";
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPortal(username, password);
		
		DashboardPage dp = new DashboardPage(driver);
		dp.subscribeToCourse();
	}
}
