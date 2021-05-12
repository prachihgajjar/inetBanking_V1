package com.inetBankingV1.testCases;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
		@Test
		public void loginTest() throws IOException {
			
			logger.info("URL is opened");
			LoginPage lg = new LoginPage(driver);
			lg.setUsername(username);
			logger.info("Entered username");
			
			lg.setPassword(password);
			logger.info("Entered password");
			lg.clickLogin();
			
			if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				Assert.assertTrue(true);
				logger.info("login test passed");
			}
			else {
				captureScreen(driver, "LoginTest");
				Assert.assertTrue(false);
				logger.info("login test failed");
			}
			
			
		}

}
