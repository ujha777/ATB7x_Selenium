package org.example;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumDemo7_WebTable2 {
    WebDriver driver;
    WebElement Element;
    JavascriptExecutor js;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }

    @Test
    public void allcheckbox_in_table() {
        driver.findElement(By.xpath(" //span[text()='PIM']")).click();
        js = (JavascriptExecutor) driver;
        //Locating element by link text and store in variable "Element"
        Element = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        List<WebElement> checkoxes = driver.findElements(By.xpath("//div[@class='oxd-table-card-cell-checkbox']"));
        int countcheckbox = driver.findElements(By.xpath("//div[@class='oxd-table-card-cell-checkbox']")).size();
        System.out.println(countcheckbox);
        //select all check box
        for (WebElement cb : checkoxes) {
            cb.click();
        }
    }

    @Test
    public void verify_checkbox_selected_in_a_table() {
        driver.findElement(By.xpath(" //span[text()='PIM']")).click();
        js = (JavascriptExecutor) driver;
        //Locating element by link text and store in variable "Element"
        Element = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

        String values = null;

        List<WebElement> specElement = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[12]"));
        WebElement cbx = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div[12]/div/div/div"));
        //select sepcific checkbox from a table
        for (WebElement el : specElement) {
            values = el.getText();
            System.out.println(values);
            if (!cbx.isSelected()) {
                cbx.click();
            }
        }

    }


    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }


}




