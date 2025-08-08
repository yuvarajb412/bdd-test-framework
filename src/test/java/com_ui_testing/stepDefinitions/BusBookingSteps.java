package com_ui_testing.stepDefinitions;

import com_ui_testing.pages.BusBookingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BusBookingSteps {

    private static final Logger log = LogManager.getLogger(BusBookingSteps.class);
    BusBookingPage busPage = new BusBookingPage();

    @When("user enters {string} as source city")
    public void user_enters_source_city(String fromCity) {
        log.info("Entering source city: {}", fromCity);
        busPage.enterSourceCity(fromCity);
    }

    @When("user enters {string} as destination city")
    public void user_enters_destination_city(String toCity) {
        log.info("Entering destination city: {}", toCity);
        busPage.enterDestinationCity(toCity);
    }

    @When("user selects tomorrow's date")
    public void user_selects_tomorrows_date() {
        log.info("Selecting tomorrow's date.");
        busPage.selectTomorrowDate();
    }

    @When("user clicks on Search Buses button")
    public void user_clicks_on_search_buses_button() {
        log.info("Clicking on Search Buses button.");
        busPage.clickSearch();
    }

    @Then("bus search results should be displayed")
    public void bus_search_results_should_be_displayed() {
        log.info("Validating that bus search results are displayed.");
        boolean isDisplayed = busPage.isSearchResultDisplayed();
        Assert.assertTrue(isDisplayed, "Search results not displayed");
        log.info("Search results displayed successfully: {}", isDisplayed);
    }
}
