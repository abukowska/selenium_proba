package com.tests.web;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


@DisplayName("webdriver test")
public class Tests2 {

	
	
	
	@Test
	@DisplayName("Test 001 -- Check whether division by zero will throw an error.")
	public void divisionByZero() {
		System.setProperty("webdriver.gecko.driver", "/home/jzawadzka/Downloads/geckodriver");
		
		FirefoxOptions options = new FirefoxOptions().addPreference("browser.download.dir", "/home/jzawadzka/Downloads").addPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
			    WebDriver driver = new FirefoxDriver(options);
			    driver.get("https://github.com/mozilla/geckodriver/releases");
			    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/ul/li[7]/a")).click();
		
			    
	
		File file = new File("src/main/resources/new.file");
		String absoluteProjFilePath = file.getAbsolutePath();
	}
	
}
