Feature: Sorting Flight Results by Price

  Scenario: Sort flight results by price
    Given user is on the flight search page
    When user sorts the flight results by price
    Then the system displays flights sorted by price