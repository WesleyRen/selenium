package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        final String driverName = Utils.getDriverName(args);
        final WebDriver driver = Utils.getWebDriver(driverName);

        login(driver);
        logout(driver);

        driver.close();
        System.exit(0);
    }

    public static void login(WebDriver driver) throws InterruptedException {
        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        String username = "wes";
        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("submit")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello " + username + ",");
    }

    private static void logout(WebDriver driver) {
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
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