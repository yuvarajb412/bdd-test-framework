Feature: Sorting Flight Results by Price

  Scenario: Sort flight results by price in ascending order
    Given a list of flight search results is displayed
    When the user selects the "Sort by Price" option from the sorting dropdown menu
    Then the flight results should be reordered
    And the lowest-priced flight should be displayed first