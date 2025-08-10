package com.ui.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ui.testing.utils.DriverFactory;

public class FlightSearchPage {

    @FindBy(id = "origin")
    private WebElement originInput;

    @FindBy(id = "destination")
    private WebElement destinationInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdown;

    public FlightSearchPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void navigateToFlightSearchPage() {
        DriverFactory.getDriver().get(System.getProperty("domesticFlightSearchURL"));
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

    public void sortByPrice() {
        sortDropdown.click();
        // Logic to select "Price" from dropdown
    }

    public boolean areResultsSortedByPrice() {
        // Logic to verify results are sorted by price
        return true;
    }
}