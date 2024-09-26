package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumDemo6_WebTable {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver  = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
    }

    @Test
    public void table() {
      // String coun= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[2]/td[3]")).getText();
      //  System.out.println(coun);
        List<WebElement> cells = driver.findElements(By.xpath("./*"));



        for (WebElement cell : cells) {
        //  System.out.println(cell.getText());
            //Who is in Google
            if (cell.getText().contains("Google")){
                String name = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[2]/td[2]")).getText();
                System.out.println(name);
            }
            //Google in which Country
            if (cell.getText().contains("Google")){
                String country = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[2]/td[3]")).getText();
                System.out.println(country);
         }
            //Find Hellen Bennet in which country

            if (cell.getText().contains("Helen Bennett")){
                String country = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[5]/td[3]")).getText();
                System.out.println(country);
            }
        }




    }

   @AfterMethod
    public void closeBrowser(){
        driver.close();
   }
}
