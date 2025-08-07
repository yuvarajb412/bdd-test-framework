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
