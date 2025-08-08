package com.ui.testing.stepDefinitions;

import com.ui.testing.pages.HolidayPackagePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class HolidaySteps {

    private static final Logger log = LogManager.getLogger(HolidaySteps.class);
    private HolidayPackagePage holidayPage = new HolidayPackagePage();

    @And("user selects {string} as the From city")
    public void user_selects_from_city(String fromCity) {
        log.info("Selecting From city: {}", fromCity);
        holidayPage.enterFromCity(fromCity);
    }

    @And("user selects {string} as the To city or category")
    public void user_selects_to_city(String toCity) {
        log.info("Selecting To city/category: {}", toCity);
        holidayPage.enterToCity(toCity);
    }

    @And("user selects departure date after {int} days")
    public void user_selects_departure_date_after_days(int days) {
        log.info("Selecting departure date after {} days from today.", days);
        holidayPage.selectDepartureDateAfterDays(days);
    }

    @And("user sets guests as {string}")
    public void user_sets_guests(String guests) {
        log.info("Setting guests as: {}", guests); // Although value is hardcoded
        holidayPage.setGuests();
    }

    @And("user clicks the Search button")
    public void user_clicks_search_button() {
        log.info("Clicking the Search button.");
        holidayPage.clickSearchButton();
    }

    @Then("holiday packages from chennai to kerala should be displayed")
    public void validate_search_results() {
        log.info("Validating if holiday packages are displayed.");
        Assert.assertTrue(holidayPage.isResultDisplayed(), "Holiday packages not displayed.");
        log.info("Holiday packages successfully displayed.");
    }

}
