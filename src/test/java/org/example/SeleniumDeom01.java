package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDeom01 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.sdetclub.com/c/atb7x-only");
        driver.close();
    }
}
