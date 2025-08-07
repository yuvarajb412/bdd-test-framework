package com.ui.testing.pages;

import com.ui.testing.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;

public class BusBookingPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(BusBookingPage.class);

    public BusBookingPage() {
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
        log.info("BusBookingPage initialized.");
    }

    @FindBy(xpath = "//input[@id=\"fromCity\"]")
    private WebElement sourceCityInput;

    @FindBy(xpath = "//div[@role=\"combobox\"]/input")
    private WebElement sourceTypingField;

    @FindBy(xpath = "//ul[@role='listbox']//li/div/p/span[text() =\"Chennai, Tamil Nadu\"]")
    private WebElement sourceSuggestion;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement destinationTypingField;

    @FindBy(xpath = "//ul[@role='listbox']//li[1]")
    private WebElement destinationSuggestion;

    @FindBy(xpath = "//button[@id=\"search_button\"]")
    private WebElement searchBusesBtn;

    public void enterSourceCity(String source) {
        log.info("Entering source city: {}", source);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(sourceCityInput)).click();
        wait.until(ExpectedConditions.visibilityOf(sourceTypingField)).sendKeys(source);
        waitForSuggestionAndClick(sourceSuggestion);
    }



    public void enterDestinationCity(String destination) {
        log.info("Entering destination city: {}", destination);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(destinationTypingField)).sendKeys(destination);
        waitForSuggestionAndClick(destinationSuggestion);
    }


    public void selectTomorrowDate() {
        log.info("Selecting tomorrow's date for travel.");

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy", Locale.ENGLISH);
        String formattedDate = tomorrow.format(formatter);

        String dayXpath = "//div[contains(@class,'DayPicker-Day') and @aria-label='" + formattedDate + "']";

        try {
            WebElement tomorrowDate = driver.findElement(By.xpath(dayXpath));
            tomorrowDate.click();
            log.info("Selected travel date: {}", formattedDate);
        } catch (NoSuchElementException e) {
            log.error("Tomorrow date not found in calendar. XPath: {}", dayXpath, e);
            throw e;
        }
    }

    public void clickSearch() {
        log.info("Clicking on Search Buses button.");
        searchBusesBtn.click();
    }

    private void waitForSuggestionAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            log.info("Suggestion clicked successfully.");
        } catch (TimeoutException e) {
            log.error("Suggestion element not clickable within timeout.", e);
            throw e;
        }
    }

    public boolean isSearchResultDisplayed() {

        log.info("Checking if bus search results are displayed.");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            List<WebElement> busCards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[starts-with(@id, 'listing-bus-card') or contains(@class, 'busCardContainer')]")
            ));
            boolean result = !busCards.isEmpty();
            log.info("Bus search result displayed: {}", result);
            return result;
        } catch (TimeoutException e) {
            log.warn("No search results displayed within timeout.");
            return false;
        }
    }
}
