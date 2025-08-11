Feature: Sort Hotels by Price

  Scenario: Sort hotels in ascending order of price
    Given a search query has been executed
    And results are displayed
    When the user selects the "Sort by Price" option
    Then the list of hotels is sorted in ascending order of price
    And the sorting option is visually highlighted to indicate the active sort criteria