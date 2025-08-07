package com.ui.testing.hooks;

import com.ui.testing.utils.configReader;
import com.ui.testing.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class);
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        log.info("===== Starting Scenario: {} =====", scenario.getName());
        configReader.loadConfig();
        driver = DriverFactory.getInstance().initDriver(configReader.get("browser"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.error("Scenario failed: {}", scenario.getName());
        } else {
            log.info("Scenario passed: {}", scenario.getName());
        }
        DriverFactory.getInstance().quitDriver();
        log.info("===== Finished Scenario: {} =====", scenario.getName());
    }
}
