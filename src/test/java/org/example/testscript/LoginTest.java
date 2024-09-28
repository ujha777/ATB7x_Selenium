package org.example.testscript;

import org.example.page.LoginPage_POM;

import org.example.page.Loginpage_PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    public WebDriver driver;
    public LoginPage_POM loginPagePom;
    public Loginpage_PageFactory loginpagePageFactory;
    @BeforeMethod
    public void initializeDriver() {


      driver=new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     // return driver;
    }

    @Test
    public void test1(){
        loginPagePom=new LoginPage_POM(driver);
        loginPagePom.getUn("jhagangeshgunjan@gmail.com");
        loginPagePom.getPw("Jha@123gg");
        loginPagePom.getLoginbutton();

    }

    @Test
    public void test2(){
        loginpagePageFactory=new Loginpage_PageFactory(driver);
        loginpagePageFactory.loginToVWO("jhagangeshgunjan@gmail.com","Jha@123gg");
    }
}
