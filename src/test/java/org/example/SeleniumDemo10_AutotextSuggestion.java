package org.example;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo10_AutotextSuggestion {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

    }

    @Test
    public void autoTexthandle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        closeModal.click();

        Actions actions = new Actions(driver);
        // WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
        // wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
        WebElement ele = driver.findElement(By.xpath("//label[@for='fromCity']"));
        actions.moveToElement(ele).click().build().perform();

        try {
            List<WebElement> cities = driver.findElements(By.xpath("//ul[@role='listbox']/li/div/div/div/div/div/p"));


            for (WebElement fromcity : cities) {
                if (fromcity.getText().contains("Mumbai, India")) {
                    fromcity.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            e.getMessage();
        }


    /*   By locator = By.xpath("//p[contains(text(),'Mumbai, India')]");
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]"));

                // Handle stale element with wait
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait1.ignoring(StaleElementReferenceException.class)
                        .until(ExpectedConditions.presenceOfElementLocated(locator));

                // Interact with the element
                if (element != null) {
                    System.out.println("FromCity --->"+element.getText());
                    element.click();

                }*/

        }


}


