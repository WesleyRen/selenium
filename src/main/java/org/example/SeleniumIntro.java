package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {
    public static void main(String[] args) {
        // Invoking Browser.
        // Chrome - ChromeDriver -> Methods
        // create ChromeDriver object

        // Step 1: Set the path of the driver
        // step to invoke the driver
        // Or, using a Selenium manager, but the manager will do
        System.setProperty("webdriver.chrome.driver", "/Users/wes/Documents/webdriver/chromedriver");
        WebDriver chromeDriver = new ChromeDriver(); // Can be FirefoxDriver, SafariDriver, etc.

        // Firefox, gecko driver
        System.setProperty("webdriver.gecko.driver", "/Users/wes/Documents/webdriver/geckodriver");
        WebDriver firefoxDriver = new FirefoxDriver();

        // MS edge driver -- NM, I don't have EDge browser.
//        System.setProperty("webdriver.edge.driver", "/Users/wes/Documents/webdriver/msedgedriver");
//        WebDriver edgeDriver = new EdgeDriver();
//        edgeDriver.get("https://rahulshettyacademy.com/");
//        edgeDriver.close();

        WebDriver[] drivers = {chromeDriver, firefoxDriver};
        for (WebDriver driver : drivers) {
            driver.get("https://rahulshettyacademy.com/");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getPageSource());
            driver.close();
//            driver.quit(); // close all the associated windows
        }
    }
}