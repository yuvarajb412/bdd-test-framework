Feature: Filter Hotels by Amenities

  Scenario: Filter hotels with Free Wi-Fi and Parking
    Given a search query has been executed
    And results are displayed
    When the user applies filters for "Free Wi-Fi" and "Parking"
    And clicks the "Apply Filters" button
    Then the list of hotels is updated to show only those with Free Wi-Fi and Parking
    And the applied filters are displayed at the top of the results page for user reference