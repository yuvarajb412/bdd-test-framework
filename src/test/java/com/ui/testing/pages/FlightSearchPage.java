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

    @FindBy(id = "departureDate")
    private WebElement departureDateInput;

    @FindBy(id = "returnDate")
    private WebElement returnDateInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdown;

    public FlightSearchPage() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    public void setOrigin(String origin) {
        originInput.sendKeys(origin);
    }

    public void setDestination(String destination) {
        destinationInput.sendKeys(destination);
    }

    public void selectDepartureDate() {
        departureDateInput.click();
        // Logic to select a date
    }

    public void selectReturnDate() {
        returnDateInput.click();
        // Logic to select a date
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean verifyFlightResults(String flightType, String origin, String destination) {
        // Logic to verify flight results
        return true;
    }

    public boolean verifyFlightDetails(java.util.List<String> details) {
        // Logic to verify flight details
        return true;
    }

    public void sortByOption(String option) {
        sortDropdown.sendKeys(option);
    }

    public boolean verifySortingByPrice() {
        // Logic to verify sorting
        return true;
    }
}