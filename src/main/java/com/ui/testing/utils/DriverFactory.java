package com.ui.testing.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final Logger log = LogManager.getLogger(DriverFactory.class);
    private static DriverFactory instance = null;
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    private DriverFactory() {}


    public static DriverFactory getInstance() {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                    log.info("DriverFactory instance created.");
                }
            }
        }
        return instance;
    }

    public WebDriver initDriver(String browser) {
        log.info("Initializing WebDriver for browser: {}", browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup(); // ← Only here
            driver.set(new ChromeDriver());
            log.info("ChromeDriver launched successfully.");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup(); // ← Only here
            driver.set(new FirefoxDriver());
            log.info("FirefoxDriver launched successfully.");
        } else {
            log.error("Unsupported browser: {}", browser);
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();
        return getDriver();
    }


    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            log.info("Driver session quit successfully.");
            driver.remove();
        }
    }
}

