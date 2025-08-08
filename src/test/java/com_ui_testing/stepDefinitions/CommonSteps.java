package com_ui_testing.stepDefinitions;

import com_ui_testing.pages.HomePage;
import com_ui_testing_utils.configReader;
import com_ui_testing_utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonSteps {

    private static final Logger log = LogManager.getLogger(CommonSteps.class);
    private HomePage homePage;

    @Given("user is on MakeMyTrip homepage with popup closed")
    public void user_is_on_make_my_trip_homepage_with_popup_closed() {
        log.info("Navigating to MakeMyTrip homepage.");
        DriverFactory.getInstance().getDriver().get(configReader.get("url"));
        homePage = new HomePage();
        log.info("Closing login/signup popup if present.");
        homePage.closePopupIfPresent();
    }

    @When("user navigates to the Buses tab")
    public void user_clicks_buses_tab() {
        log.info("Clicking on Buses tab.");
        homePage.clickBusesTab();
    }

    @When("user navigates to the Holiday Packages tab")
    public void user_navigates_to_the_holiday_packages_tab() {
        log.info("Clicking on Holiday Packages tab.");
        homePage.clickHolidayPackageTab();
    }
}
