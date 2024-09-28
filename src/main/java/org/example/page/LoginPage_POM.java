package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage_POM {
    WebDriver driver;
    public LoginPage_POM(WebDriver driver){
       // super(driver);
        this.driver=driver;

    }
    private   By  un= By.id("login-username");
    private By pw=By.id("login-password");
    private By loginbutton=By.id("js-login-btn");

    public void getUn(String username) {
        driver.findElement(un).sendKeys(username);
    }

    public void getPw(String password) {
        driver.findElement(pw).sendKeys(password);
    }

    public void getLoginbutton() {
        driver.findElement(loginbutton).click();
    }
}
