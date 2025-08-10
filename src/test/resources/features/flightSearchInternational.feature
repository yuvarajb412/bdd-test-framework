Feature: International Flight Search

  Scenario: Search international flight from New York to London
    Given user is on the flight search page
    When user searches for an international flight from "New York" to "London"
    Then available flight results should be displayed