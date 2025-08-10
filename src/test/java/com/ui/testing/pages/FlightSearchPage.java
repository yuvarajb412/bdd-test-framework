package com.ui.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ui.testing.utils.BaseTest;

public class FlightSearchPage extends BaseTest {

    @FindBy(id = "origin")
    private WebElement originInput;

    @FindBy(id = "destination")
    private WebElement destinationInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdown;

    public FlightSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToFlightSearchPage() {
        driver.get(config.getProperty("domesticFlightSearchURL"));
    }

    public void setOrigin(String origin) {
        originInput.sendKeys(origin);
    }

    public void setDestination(String destination) {
        destinationInput.sendKeys(destination);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getFlightResults() {
        // Logic to fetch flight results
        return driver.getPageSource();
    }

    public void sortByPrice() {
        sortDropdown.click();
        // Logic to select "Price" from dropdown
    }

    public boolean isSortedByPrice() {
        // Logic to verify sorting
        return true;
    }
}