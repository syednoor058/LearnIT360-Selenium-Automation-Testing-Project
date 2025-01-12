package com.learnit360.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.learnit360.pages.BaseTest;
import com.learnit360.pages.LoginPage;
import com.learnit360.utilities.ReadExcelFile;

public class LoginDataDrivenTest extends BaseTest {
	
	String fileName = System.getProperty("user.dir") + "\\TestData\\TestData.xlsx";

	@Test (priority=1, dataProvider="LoginDataProvider")
	void verifyLoginWithDrivenData(String username, String password){
		LoginPage lp = new LoginPage(driver);
		lp.loginPortal(username, password);
//		lp.logOut();		
		
		if(username.equals("Demo12") && password.equals("Test123456$")){
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logOut();
		}
		else{
			captureScreenShot(driver, "VerifyLoginWithDrivenData");
			Assert.assertTrue(false);
		}
		
	}
	
	@DataProvider (name="LoginDataProvider")
	public String[][] LoginDataProvider(){
		int totalRows = ReadExcelFile.getRowCount(fileName, "LoginData");
		int totalCols = ReadExcelFile.getColumnCount(fileName, "LoginData");
		
		String data[][] = new String[totalRows][totalCols];
		
		for(int i=0; i<totalRows; i++) {
			for(int j=0; j<totalCols; j++) {
				data[i][j] = ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		
		return data;
	}
}