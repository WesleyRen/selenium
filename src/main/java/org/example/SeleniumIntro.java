package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class SeleniumIntro {
    private static final String defaultDriver = "chrome";
    private static final Set<String> allDrivers = Set.of("chrome", "firefox", "edge");

    public static void main(String[] args) {
        System.out.println(String.join(" ", args));
        String driverName = defaultDriver;
        if (args.length > 0 && allDrivers.contains(args[0])) {
            driverName = args[0];
        }
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
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.id("inputUsername")).sendKeys("wes");
            driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy-bad");
            driver.findElement(By.className("submit")).click();
            System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        driver.close();
//            driver.quit(); // quite the driver, which closes all the associated windows
        System.exit(0);
    }
}