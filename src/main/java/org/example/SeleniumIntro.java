package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {
    public static void main(String[] args) {
        System.out.println(String.join(" ", args));
        String driverName = args.length > 0 ? args[0] : "firefox";
        WebDriver driver;

        if (driverName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/wes/Documents/webdriver/chromedriver");
            driver = new ChromeDriver();
        } else if (driverName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/wes/Documents/webdriver/geckodriver");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.edge.driver", "/Users/wes/Documents/webdriver/msedgedriver");
            driver = new EdgeDriver(); // Microsoft Edge, need Edge browser installed to work.
        }

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        try {
            driver.findElement(By.id("inputUsername")).sendKeys("wes");
            driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
            driver.findElement(By.className("submit")).click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        driver.close();
//            driver.quit(); // quite the driver, which closes all the associated windows
        System.exit(0);
    }
}