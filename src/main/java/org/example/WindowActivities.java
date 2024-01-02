package org.example;

import org.openqa.selenium.WebDriver;

public class WindowActivities {
    public static void main(String[] args) {

        final String driverName = Utils.getDriverName(args);
        final WebDriver driver = Utils.getWebDriver(driverName);

        driver.manage().window().maximize();
        driver.get("http://google.com");
        driver.navigate().to("https://rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.close();
        System.exit(0);
    }
}

