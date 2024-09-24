package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo4_StaticDropdown {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

    }
    @Test
    public void TC_selectByIndex()  {

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);
        select.selectByIndex(2);
    }
    @Test
    public void TC_selectByValue()  {

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);
        select.selectByValue("1");

    }
    @Test
    public void TC_selectByVisibleText()  {

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Option 2");

    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
