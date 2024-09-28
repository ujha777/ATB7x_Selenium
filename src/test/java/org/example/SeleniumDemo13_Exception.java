package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumDemo13_Exception {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

    }

    @Test
    public void test(){
        try {
            WebElement username = driver.findElement(By.id("login-username"));
            driver.navigate().refresh();
            username.sendKeys("jhagangeshgunjan@gmail.com");
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }


    }
}
