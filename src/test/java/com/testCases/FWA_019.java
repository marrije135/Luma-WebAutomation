package com.testCases;

import java.io.IOException;

//import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LoginPage;

public class FWA_019 extends BaseClass{
	
	@Test(priority=1)
	public void freshiiLogin() throws Exception {
		
		LoginPage logPage=new LoginPage(driver);
		logPage.loginclick();
		logPage.settxtemail(username1);
		logPage.settxtpassword(password);
		logPage.clkbtnSubmit();
		SoftAssert softAssert=new SoftAssert();
		if(driver.getTitle().equalsIgnoreCase("Freshii")) {
			softAssert.assertTrue(true);
			logger.info("Test Passed Successfully");
			//logPage.signOut();
		}
		else {
			softAssert.assertTrue(false);
			logger.error("Test Failed! Login failed!");
			try {
				captureScreen(driver,"validEmailandPwd");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		softAssert.assertAll();
		logger.info("Completed Logintest");
	}
	
}
