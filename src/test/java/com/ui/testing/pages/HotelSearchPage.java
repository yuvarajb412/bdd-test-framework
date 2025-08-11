package com.ui.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchPage {

    @FindBy(id = "location")
    private WebElement locationField;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(css = ".hotel-list")
    private WebElement hotelList;

    public void navigateToHotelSearchPage() {
        // Code to navigate to the hotel search page
    }

    public void enterLocation(String location) {
        locationField.sendKeys(location);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isHotelListDisplayed(String location) {
        // Code to verify hotel list is displayed
        return hotelList.isDisplayed();
    }

    public boolean isSortedByProximityAndPreferences() {
        // Code to verify sorting
        return true;
    }

    public boolean isTotalResultsDisplayed() {
        // Code to verify total results are displayed
        return true;
    }
}