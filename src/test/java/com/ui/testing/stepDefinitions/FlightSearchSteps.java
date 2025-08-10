package com.ui.testing.stepDefinitions;

import com.ui.testing.pages.FlightSearchPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class FlightSearchSteps {

    private FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("user is on the flight search page")
    public void userIsOnFlightSearchPage() {
        flightSearchPage.navigateToFlightSearchPage();
    }

    @When("user searches for a domestic flight from {string} to {string}")
    public void userSearchesDomesticFlight(String origin, String destination) {
        flightSearchPage.setOrigin(origin);
        flightSearchPage.setDestination(destination);
        flightSearchPage.clickSearchButton();
    }

    @When("user searches for an international flight from {string} to {string}")
    public void userSearchesInternationalFlight(String origin, String destination) {
        flightSearchPage.setOrigin(origin);
        flightSearchPage.setDestination(destination);
        flightSearchPage.clickSearchButton();
    }

    @When("user sorts the flight results by price")
    public void userSortsResultsByPrice() {
        flightSearchPage.sortByPrice();
    }

    @Then("the system displays flights sorted by price")
    public void verifyFlightsSortedByPrice() {
        Assert.assertTrue(flightSearchPage.areResultsSortedByPrice());
    }
}