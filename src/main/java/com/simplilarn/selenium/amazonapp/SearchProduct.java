package com.simplilarn.selenium.amazonapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {
	
static WebDriver driver =null;
	
	public static void main(String[] args) throws InterruptedException {
		
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/chromedriver.exe";
		System.setProperty("webdriver.chromedriver.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(siteUrl);
		
		searchProduct();
		driver.close();
	}
	
	public static void searchProduct() throws InterruptedException {
		   WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
	       searchInput.sendKeys("iPhone 13" + Keys.RETURN);
	       
	       String expTitle = "Amazon.in : iPhone 13";
	       String actTitle = driver.getTitle();
	       if(expTitle.equals(actTitle)) {
	    	   System.out.println("Iphone results are displayed");
	       }else
	       {
	    	   System.out.println("Iphone results are not displayed"); 
	       }
	       
	       System.out.println("Expected Title:"+expTitle);
	       System.out.println("Actual Title:"+actTitle);
	     
	   }

}
