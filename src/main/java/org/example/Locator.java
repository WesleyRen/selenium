package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class Locator {
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
            driver.findElement(By.linkText("Forgot your password?")).click();

            Thread.sleep(500);
            driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("wes2");
            driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("wes@wes.com");
            driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); // different ways of selecting.
            driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("wes@gmail.com"); // different ways of selecting.
            driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");

            driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
            System.out.println(driver.findElement(By.cssSelector("form p")).getText());
            driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

            Thread.sleep(500);
            driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
            driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
            driver.findElement(By.id("chkboxOne")).click();
            driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.close();
//            driver.quit(); // quite the driver, which closes all the associated windows
            System.exit(0);
        }
    }
}