package com.ui.testing.stepDefinitions;

import com.ui.testing.pages.FlightSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FlightSearchSteps {

    private FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("the user is on the flight search page")
    public void userIsOnFlightSearchPage() {
        flightSearchPage.navigateToFlightSearchPage();
    }

    @When("the user enters {string} as the origin and {string} as the destination")
    public void userEntersOriginAndDestination(String origin, String destination) {
        flightSearchPage.setOrigin(origin);
        flightSearchPage.setDestination(destination);
    }

    @When("clicks the search button")
    public void userClicksSearchButton() {
        flightSearchPage.clickSearchButton();
    }

    @Then("the system displays a list of domestic flights")
    public void systemDisplaysDomesticFlights() {
        Assert.assertTrue(flightSearchPage.getFlightResults().contains("Domestic Flights"),
                "Expected Domestic Flights to appear in the search results.");
    }

    @Then("the system displays a list of international flights")
    public void systemDisplaysInternationalFlights() {
        Assert.assertTrue(flightSearchPage.getFlightResults().contains("International Flights"),
                "Expected International Flights to appear in the search results.");
    }

    @When("the user sorts the results by price")
    public void userSortsResultsByPrice() {
        flightSearchPage.sortByPrice();
    }

    @Then("the system displays flights sorted by price")
    public void systemDisplaysFlightsSortedByPrice() {
        Assert.assertTrue(flightSearchPage.isSortedByPrice(),
                "Expected flights to be sorted by price.");
    }
}