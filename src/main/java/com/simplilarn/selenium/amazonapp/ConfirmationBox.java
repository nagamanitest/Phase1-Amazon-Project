package com.simplilarn.selenium.amazonapp;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ConfirmationBox {
	
static WebDriver driver =null;
	
public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get("https://www.amazon.in/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.findElement(By.linkText("Mobiles")).click();
    WebElement mobile = driver.findElement(By.xpath("//*[@id='nav-subnav']/descendant::span[2]"));
    Actions actions = new Actions(driver);
    actions.moveToElement(mobile).build().perform();

    Thread.sleep(2000); 
    driver.findElement(By.linkText("Apple")).click();

    Thread.sleep(2000);
    driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone')])[1]")).click();

    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));

    Thread.sleep(2000);
    driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(5000);

   
    WebElement confirmationBox = driver.findElement(By.xpath("//div[contains(@class, 'a-popover-inner')]"));
    if (confirmationBox.isDisplayed()) {
        
        driver.findElement(By.id("attach-view-cart-button-form")).click();
    }

  
    driver.quit();
}

}
