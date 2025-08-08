package com.ui.testing.pages;
import com.ui.testing.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;



public class HolidayPackagePage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(HolidayPackagePage.class);

    public HolidayPackagePage() {
        this.driver =  DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id=\"fromCity\"]")
    private WebElement fromCityInput;

    @FindBy(xpath = "//input[@placeholder=\"Enter City\"]")
    private WebElement sourceTypingField;

    @FindBy(xpath = "//div[@class=\"searchedCity\"]/ul/li/p/span/b[text()=\"Chennai, \"]")
    private WebElement sourceSuggestion;

    @FindBy(xpath = "//input[@id=\"toCity\"]")
    private WebElement toCityInput;

    @FindBy(xpath = "//input[@placeholder=\"To\"]")
    private WebElement destinationTypingField;

    @FindBy(xpath = "//div[text()=\"Kerala\"]")
    private WebElement destinationSuggestion;

    @FindBy(xpath = "//div[contains(text(),'Rooms & Guests')]")
    private WebElement guestsSection;

    @FindBy(xpath = "//div[@data-testid=\"adult-increment-counter\"]")
    private WebElement selectAdults;

    @FindBy(xpath = "//button[text()=\"APPLY\"]")
    private WebElement applyGuestButton;

    @FindBy(xpath = "//button[@id=\"search_button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class=\"close closeIcon\"]")
    private  WebElement closeQuoteTab;

    @FindBy(xpath = "//div[@class=\"packageDetails\"]//div[@class=\"packageCardList\"]/section")
    private List<WebElement> resultsText;

    public void enterFromCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        log.info("Trying to close modal if it appears...");
        closeModalIfPresent();

        log.info("Clicking on 'From' city input field...");
        wait.until(ExpectedConditions.elementToBeClickable(fromCityInput)).click();

        closeModalIfPresent();

        log.info("Clearing the existing text...");
        wait.until(ExpectedConditions.visibilityOf(sourceTypingField)).clear();

        log.info("Typing source city: {}", city);
        wait.until(ExpectedConditions.visibilityOf(sourceTypingField)).sendKeys(city);

        log.info("Waiting for suggestion and clicking...");
        wait.until(ExpectedConditions.elementToBeClickable(sourceSuggestion)).click();
    }


    public void enterToCity(String city) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        log.info("Waiting for 'To City' input field to be clickable...");

        wait.until(ExpectedConditions.elementToBeClickable(toCityInput)).click();
        log.info("Waiting for destination typing field to be visible...");

        wait.until(ExpectedConditions.visibilityOf(destinationTypingField)).sendKeys(city);
        log.info("Waiting for destination suggestion to be clickable...");

        wait.until(ExpectedConditions.elementToBeClickable(destinationSuggestion)).click();
        log.info("To City entered: {}", city);
    }

    public void setGuests() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        log.info("Incrementing adult guest count...");
        wait.until(ExpectedConditions.elementToBeClickable(selectAdults)).click();

        log.info("Clicking on 'Apply' button...");
        wait.until(ExpectedConditions.elementToBeClickable(applyGuestButton)).click();

        log.info("Clicking outside to close any auto-opened filter panel...");
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().build().perform();

        log.info("Guest selection completed.");
    }


    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isResultDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        log.info("Waiting for holiday package results to be visible...");

        List<WebElement> resultList = wait.until(ExpectedConditions.visibilityOfAllElements(resultsText));

        boolean isDisplayed;
        isDisplayed = resultList != null && !resultList.isEmpty();
        log.info("Holiday package results found: {}", isDisplayed);
        return isDisplayed;
    }


    public void selectDepartureDateAfterDays(int daysAfterToday) {
        LocalDate tomorrow = LocalDate.now().plusDays(daysAfterToday);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy", Locale.ENGLISH);
        String formattedDate = tomorrow.format(formatter);

        String xpath = "//div[contains(@class,'DayPicker-Day') and @aria-label='" + formattedDate + "']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            dateElement.click();
            log.info("Departure date selected: {}", formattedDate);
        } catch (NoSuchElementException e) {
            log.error("Departure date not found in calendar. XPath: {}", xpath, e);
            throw e;
        }

    }

    public void closeModalIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Cancel']")));
            cancelButton.click();
            log.info("Location modal closed by clicking Cancel.");
        } catch (Exception e) {
            log.info("No modal popup appeared, continuing...");
        }
    }





}
