package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumDemo16_RelativeLocator {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Open a webpage
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();
        WebElement e = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        driver.findElement(RelativeLocator.with(By.id("exp-3")).toRightOf(e)).click();

    }
}
