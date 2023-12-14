package com.simplilarn.selenium.amazonapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyUser {
	
	static WebDriver driver =null;
	
	public static void main(String[] args) throws InterruptedException {
		
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/chromedriver.exe";
		System.setProperty("webdriver.chromedriver.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(siteUrl);
		
		verifySignin();
		login();
		
		Thread.sleep(3000);
		driver.close();
	  
	}
public static void verifySignin() {
		
		WebElement signInElement = driver.findElement(By.id("nav-link-accountList"));
		
		if (signInElement.isDisplayed()) {
            System.out.println("User is signed in.");
        } else {
            System.out.println("User is not signed in.");
        }
		WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
		signInLink.click();
	
	}
   public static void login() {
		
		String username = Login.username;
        String password = Login.pwd;
		
		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		
		
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")));
				if(user.getText().equals("Hello, chintu")) {
					System.out.println("User is signed in  Amazon account!");
				}else {
					System.out.println("User is not signed in Amazon account");
				}
		System.out.println(user.getText());
		
		
	}
}
