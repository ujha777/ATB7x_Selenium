package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumDemo11_FileUpload {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/selenium/upload.html");

    }

    @Test
    public void test(){
        WebElement uploadFile = driver.findElement(By.xpath("//input[@value='Upload File']"));
        uploadFile.sendKeys("src/test/java/org/example/uploadDataFile");
        driver.findElement(By.name("submit")).click();


    }
}
