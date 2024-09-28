package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.ID;

public class Loginpage_PageFactory {
    WebDriver driver;
    public Loginpage_PageFactory(WebDriver driver){
        this.driver= this.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="login-username")
    WebElement un;
    @FindBy(id="login-password")
    WebElement pw;
    @FindBy(how = ID, using="js-login-btn")
    WebElement loginbutton;

    public void loginToVWO(String email,String password){
        un.sendKeys(email);
        pw.sendKeys(password);
        loginbutton.click();
    }

}
