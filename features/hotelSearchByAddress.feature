Feature: Search Hotels by Address

  Scenario: Search hotels near a specific address
    Given the system is operational
    And the user is on the hotel search page
    When the user enters "1600 Amphitheatre Parkway, Mountain View, CA" in the location search field
    And clicks the "Search" button
    Then a list of hotels within a 10-mile radius of the entered address is displayed
    And hotels are sorted by proximity and user preferences
    And the entered address is pinned on the map for reference