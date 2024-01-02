package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class Locator2 {
    private static final String defaultDriver = "chrome";
    private static final Set<String> allDrivers = Set.of("chrome", "firefox", "edge");

    public static void main(String[] args) throws InterruptedException {
        String username = "wes";
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

        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("submit")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello " + username + ",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        driver.close();
        System.exit(0);
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText =driver.findElement(By.cssSelector("form p")).getText();
//Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray = passwordText.split("'");
// String[] passwordArray2 = passwordArray[1].split("'");
// passwordArray2[0]

        String password = passwordArray[1].split("'")[0];

        return password;

//0th index - Please use temporary password
//1st index - rahulshettyacademy' to Login.

//0th index - rahulshettyacademy
//1st index - to Login.
    }
}