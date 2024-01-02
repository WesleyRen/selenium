package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class Utils {
    private static final String defaultDriver = "chrome";
    private static final Set<String> allDrivers = Set.of("chrome", "firefox", "edge");

    static String getDriverName(String[] args) {
        System.out.println(String.join(" ", args));
        String driverName = defaultDriver;
        if (args.length > 0 && allDrivers.contains(args[0])) {
            driverName = args[0];
        }
        return driverName;
    }

    static WebDriver getWebDriver(String driverName) {
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
        return driver;
    }
}
