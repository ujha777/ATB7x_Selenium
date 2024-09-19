package org.example;


import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumDemo2 {
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
    @Description("Verify the scenario with invalid password but valid username")
    public void TC1_Login_invalid_pwd_valid_un() throws InterruptedException {

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("jhagangeshgunjan@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Jha@123ggg");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        String errorMsg = errorMessage.getText();


        Assert.assertEquals(errorMsg,"Your email, password, IP address or location did not match");


    }
    @Test
    @Owner("Gangesh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the scenario with valid password but invalid username")
    public void TC2_Login_valid_pwd_invalid_un() throws InterruptedException {

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("jjhagangeshgunjan@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Jha@123ggg");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        String errorMsg = errorMessage.getText();


        Assert.assertEquals(errorMsg,"Your email, password, IP address or location did not match");


    }

    @Test
    @Owner("Gangesh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the scenario with empty password and  username")
    public void TC3_Login_empty_pwd_empty_un() throws InterruptedException {

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        String errorMsg = errorMessage.getText();


        Assert.assertEquals(errorMsg,"Your email, password, IP address or location did not match");


    }
    @Test
    @Owner("Gangesh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the scenario with empty password but  valid username")
    public void TC4_Login_empty_pwd_valid_un() throws InterruptedException {
        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("jjhagangeshgunjan@gmail.com");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        String errorMsg = errorMessage.getText();


        Assert.assertEquals(errorMsg,"Your email, password, IP address or location did not match");


    }

    @Test
    @Owner("Gangesh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the scenario with valid password but  empty username")
    public void TC5_Login_valid_pwd_empty_un() throws InterruptedException {
        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Jha@123gg");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        String errorMsg = errorMessage.getText();


        Assert.assertEquals(errorMsg,"Your email, password, IP address or location did not match");


    }


    @Test
    @Owner("Gangesh")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the scenario with valid password and valid username")
    public void TC6_Login_valid_pwd_valid_un() throws InterruptedException {

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("jhagangeshgunjan@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Jha@123gg");

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();
        Thread.sleep(10000);
        String gettitle = driver.getTitle();
        String expectedTitle = "VWO Setup";


        Assert.assertEquals(gettitle,expectedTitle);


    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
