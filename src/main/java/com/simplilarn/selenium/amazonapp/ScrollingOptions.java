package com.simplilarn.selenium.amazonapp;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingOptions {
	
	static WebDriver driver =null;
	
	public static void main(String[] args) throws InterruptedException {
		
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/chromedriver.exe";
		System.setProperty("webdriver.chromedriver.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(siteUrl);
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0, 1000)"); 
	       
	       Thread.sleep(2000);
	        

	        Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
	        System.out.println("Scroll position: " + scrollPosition);
	        driver.close();
			
		
		
	}
	
	
		   
		

}
