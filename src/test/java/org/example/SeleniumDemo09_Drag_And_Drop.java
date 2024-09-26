package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo09_Drag_And_Drop {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

    }
    Actions actions;
    @Test
    public void test(){

        actions=new Actions(driver);
        WebElement from = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement to =driver.findElement(By.xpath("//div[@id='column-b']"));
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();
    }
}
