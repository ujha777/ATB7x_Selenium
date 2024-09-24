package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumDemo5_AlertPopUp {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver  = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_popup1() {

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
    }
    @Test
            public void TC_pop2(){
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();

    }
    @Test
    public void TC_pop3(){
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Prompt...");
        alert3.accept();

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
