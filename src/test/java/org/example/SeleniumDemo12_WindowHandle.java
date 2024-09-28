package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class SeleniumDemo12_WindowHandle {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

    }

    @Test
    public void test(){

        //Store the handle of the Current Window
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        //Find the Click Here link
       WebElement link=driver.findElement(By.linkText("Click Here"));
       link.click();
        //Stores the handle of all open windows
        Set<String> windowHandles=driver.getWindowHandles();

        //Iterate through the list of window handles
        for (String handle:windowHandles) {
            //Switch the force to each window in turn
            driver.switchTo().window(handle);
        }

        //Check if the text 'New Window ' is present in the window
        if (driver.getPageSource().contains("New Window")){
            System.out.println("Child window");
        }

    }
}
