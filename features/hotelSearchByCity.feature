Feature: Search Hotels by City

  Scenario: Search hotels in New York
    Given the system is operational
    And the user is on the hotel search page
    When the user enters "New York" in the location search field
    And clicks the "Search" button
    Then a list of hotels within a 10-mile radius of New York is displayed
    And hotels are sorted by proximity and user preferences
    And the total number of results is displayed at the top of the list