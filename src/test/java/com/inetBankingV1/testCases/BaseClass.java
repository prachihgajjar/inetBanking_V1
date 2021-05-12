package com.inetBankingV1.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;


public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	public String pageURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefox());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(pageURL);
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		
	}

	@AfterClass
	public void down() {
		driver.quit();

	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomMail() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(8);
		return generatedString1;
	}
	public String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}

}
