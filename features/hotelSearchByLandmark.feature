Feature: Search Hotels by Landmark

  Scenario: Search hotels near Eiffel Tower
    Given the system is operational
    And the user is on the hotel search page
    When the user enters "Eiffel Tower" in the location search field
    And clicks the "Search" button
    Then a list of hotels within a 10-mile radius of the Eiffel Tower is displayed
    And hotels are sorted by proximity and user preferences
    And the system highlights the landmark on the map for better context