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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;



public class SeleniumDemo03_ImplicitWait_ExplicitWait {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

    }

    @Test
    @Owner("Gangesh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the scenario with valid password and valid username")
    public void TC1_Login_Invalid_pwd_valid_un()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("jhagangeshgunjan@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Jha@123ggg");
        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();

        //ExplicitWait
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        String errorMessage = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id("js-notification-box-msg"))).getText();
        Assert.assertEquals(errorMessage,"Your email, password, IP address or location did not match");



    }

    @Test
    @Owner("Gangesh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the scenario with valid password and valid username")
    public void TC2_Login_valid_pwd_valid_un()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("jhagangeshgunjan@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Jha@123gg");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();
        String gettitle = driver.getTitle();
        String expectedTitle = "Login - VWO";


        Assert.assertEquals(gettitle,expectedTitle);


    }



    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
