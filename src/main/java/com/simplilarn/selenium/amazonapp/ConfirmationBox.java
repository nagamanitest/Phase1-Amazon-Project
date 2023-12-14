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

    // Navigate to Mobiles category
    driver.findElement(By.linkText("Mobiles")).click();
    WebElement mobile = driver.findElement(By.xpath("//*[@id='nav-subnav']/descendant::span[2]"));
    Actions actions = new Actions(driver);
    actions.moveToElement(mobile).build().perform();

    // Select Apple from the dropdown
    Thread.sleep(2000); // Adjust the sleep time as needed
    driver.findElement(By.linkText("Apple")).click();

    // Click on a specific product (modify the locator based on your requirement)
    Thread.sleep(2000); // Adjust the sleep time as needed
    driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone')])[1]")).click();

    // Switch to the new window/tab
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));

    // Add the product to the cart
    Thread.sleep(2000); // Adjust the sleep time as needed
    driver.findElement(By.id("add-to-cart-button")).click();

    // Wait for the confirmation box and handle it
    Thread.sleep(5000); // Adjust the sleep time as needed

    // Handle the confirmation box (modify the locator based on your requirement)
    WebElement confirmationBox = driver.findElement(By.xpath("//div[contains(@class, 'a-popover-inner')]"));
    if (confirmationBox.isDisplayed()) {
        // Close the confirmation box (click on close button or perform other actions)
        driver.findElement(By.id("attach-view-cart-button-form")).click();
    }

    // Close the browser
    //driver.quit();
}

}
