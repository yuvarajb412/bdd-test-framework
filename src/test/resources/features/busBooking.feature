Feature: Bus Booking on MakeMyTrip

  Background:
    Given user is on MakeMyTrip homepage with popup closed

  Scenario: Search buses from Chennai to Bangalore
    When user navigates to the Buses tab
    And user enters "Chennai" as source city
    And user enters "Bangalore" as destination city
    And user selects tomorrow's date
    And user clicks on Search Buses button
    Then bus search results should be displayed

  Scenario: Apply time range filter
    Given user performs a bus search
    When user applies time range filter "6 AM - 12 PM"
    Then search results should be filtered by time range

  Scenario: Apply bus type filter
    Given user performs a bus search
    When user applies bus type filter "AC Sleeper"
    Then search results should be filtered by bus type

  Scenario: Apply price range filter
    Given user performs a bus search
    When user applies price range filter "500-1000"
    Then search results should be filtered by price range

  Scenario: Sort search results by price
    Given user performs a bus search
    When user sorts results by price
    Then search results should be sorted by price

  Scenario: Search buses with invalid inputs
    Given user navigates to the bus search page
    When user enters invalid inputs for bus search
