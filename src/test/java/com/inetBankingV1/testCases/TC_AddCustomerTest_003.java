package com.inetBankingV1.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickLogin();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("Provide Customer Details");
		addcust.clickAddNewCustomer();
		addcust.custName("Prachi");
		addcust.custgender("female");
		addcust.custdob("1998\t0604");
		
		Thread.sleep(5000);
		
		addcust.custaddress("Canada");
		addcust.custcity("Simcoe");
		addcust.custstate("ON");
		addcust.custpinno("123456");
		addcust.custtelephoneno("12345678");
		String email = randomMail()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("xyz");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("Starting Validation");
		
		boolean bol = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (bol == true) {
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
		
		
		
		
	}
	



}
