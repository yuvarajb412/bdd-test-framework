Feature: Flight Search on MakeMyTrip

  Background:
    Given user is on MakeMyTrip homepage with popup closed

  Scenario: Search one-way flight from Delhi to Mumbai
    When user selects "Delhi" as the From city
    And user selects "Mumbai" as the To city
    And user selects journey date 10 days from today
    And user clicks on the Search Flights button
    Then available flight results should be displayed

  Scenario: Filter flight results by Airline and Departure Time
    When user searches flights from "Delhi" to "Mumbai" on a valid future date
    And user applies Airline filter as "IndiGo"
    And user applies Departure Time filter between 6AM to 12PM
    Then filtered flight results should be displayed
