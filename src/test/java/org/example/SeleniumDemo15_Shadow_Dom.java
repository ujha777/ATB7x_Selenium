package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo15_Shadow_Dom {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Open a webpage
        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement inputBox = (WebElement) js.executeScript("return document.querySelector(\"div.jackPart\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");
        System.out.println(inputBox.getText());
        inputBox.sendKeys("Farmhouse");
    }
}
