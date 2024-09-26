package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class SeleniumDemo8_ActionClass {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

    }
    Actions actions;
    @Test
    public void test(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions=new Actions(driver);
        WebElement target_element = driver.findElement(By.name("firstname"));
        actions.keyDown(Keys.SHIFT)
                .sendKeys(target_element,"Testing")
                .keyUp(Keys.SHIFT)
                .build().perform();
        WebElement link = driver.findElement(By.xpath("//a[text()='Click here to Download File']"));
        actions.contextClick(link).build().perform();
    }
}
