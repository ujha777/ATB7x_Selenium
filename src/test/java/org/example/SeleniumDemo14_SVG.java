package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SeleniumDemo14_SVG {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.meesho.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[1]")).sendKeys("Mobile");
        WebElement search = driver.findElement(By.xpath("//div[@placeholder='Try Saree, Kurti or Search by Product Code']/div/*[local-name()='svg']"));
        search.click();


    }
}
