package com.learnit360.testcases;

import org.testng.annotations.Test;

import com.learnit360.pages.BaseTest;
import com.learnit360.pages.LoginPage;
import com.learnit360.pages.SearchCourse;

public class SearchTest extends BaseTest {

	@Test
	public void searchCourseTest() {
		
		String username = "Demo12";
		String password = "Test123456$";
		String courseName = "Html For Beginners";
		
		LoginPage lp = new LoginPage(driver);
		SearchCourse sc = new SearchCourse(driver);
		
		lp.loginPortal(username, password);
		sc.searchForCourse(courseName);
	}


}