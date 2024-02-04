package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindButtons {
    public static void main(String[] args) {

        final String driverName = Utils.getDriverName(args);
        final WebDriver driver = Utils.getWebDriver(driverName);
// Sibling - Child to parent traverse

//header/div/button[1]/following-sibling::button[1]

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
        driver.close();
        System.exit(0);
    }
}

