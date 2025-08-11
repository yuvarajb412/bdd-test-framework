package com.ui.testing.stepDefinitions;

import com.ui.testing.pages.HotelSearchPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HotelSearchSteps {

    HotelSearchPage hotelSearchPage = new HotelSearchPage();

    @Given("the system is operational")
    public void theSystemIsOperational() {
        // Code to verify system status
    }

    @Given("the user is on the hotel search page")
    public void theUserIsOnTheHotelSearchPage() {
        hotelSearchPage.navigateToHotelSearchPage();
    }

    @When("the user enters {string} in the location search field")
    public void theUserEntersInTheLocationSearchField(String location) {
        hotelSearchPage.enterLocation(location);
    }

    @When("clicks the {string} button")
    public void clicksTheButton(String buttonName) {
        hotelSearchPage.clickSearchButton();
    }

    @Then("a list of hotels within a 10-mile radius of {string} is displayed")
    public void aListOfHotelsWithinAMileRadiusIsDisplayed(String location) {
        Assert.assertTrue(hotelSearchPage.isHotelListDisplayed(location));
    }

    @Then("hotels are sorted by proximity and user preferences")
    public void hotelsAreSortedByProximityAndUserPreferences() {
        Assert.assertTrue(hotelSearchPage.isSortedByProximityAndPreferences());
    }

    @Then("the total number of results is displayed at the top of the list")
    public void theTotalNumberOfResultsIsDisplayedAtTheTopOfTheList() {
        Assert.assertTrue(hotelSearchPage.isTotalResultsDisplayed());
    }
}