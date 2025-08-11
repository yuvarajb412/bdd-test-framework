package com.ui.testing.stepDefinitions;

import com.ui.testing.pages.FlightSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FlightSearchSteps {

    private FlightSearchPage flightSearchPage = new FlightSearchPage();

    @When("the user enters {string} as the origin")
    public void theUserEntersOrigin(String origin) {
        flightSearchPage.setOrigin(origin);
    }

    @And("enters {string} as the destination")
    public void theUserEntersDestination(String destination) {
        flightSearchPage.setDestination(destination);
    }

    @And("selects a departure date and return date")
    public void theUserSelectsDates() {
        flightSearchPage.selectDepartureDate();
        flightSearchPage.selectReturnDate();
    }

    @And("clicks the {string} button")
    public void theUserClicksSearchButton(String buttonName) {
        flightSearchPage.clickSearchButton();
    }

    @Then("the system should display a list of {string} flights between {string} and {string}")
    public void theSystemDisplaysFlights(String flightType, String origin, String destination) {
        Assert.assertTrue(flightSearchPage.verifyFlightResults(flightType, origin, destination),
            "Expected " + flightType + " flights between " + origin + " and " + destination);
    }

    @Then("the flight details should include:")
    public void theFlightDetailsShouldInclude(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertTrue(flightSearchPage.verifyFlightDetails(dataTable.asList()),
            "Expected flight details to match the provided criteria.");
    }

    @When("the user selects the {string} option from the sorting dropdown menu")
    public void theUserSelectsSortingOption(String sortingOption) {
        flightSearchPage.sortByOption(sortingOption);
    }

    @Then("the flight results should be reordered")
    public void theFlightResultsShouldBeReordered() {
        Assert.assertTrue(flightSearchPage.verifySortingByPrice(),
            "Expected flight results to be sorted by price in ascending order.");
    }
}