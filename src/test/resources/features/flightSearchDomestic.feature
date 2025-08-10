Feature: Domestic Flight Search

  Scenario: Search domestic flight from New York to Los Angeles
    Given user is on the flight search page
    When user searches for a domestic flight from "New York" to "Los Angeles"
    Then available flight results should be displayed