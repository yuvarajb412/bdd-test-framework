Feature: Domestic Flight Search

  Scenario: Search for domestic flights between New York and Los Angeles
    Given the user is logged into the system
    And the user is on the flight search page
    When the user enters "New York, USA" as the origin
    And enters "Los Angeles, USA" as the destination
    And selects a departure date and return date
    And clicks the "Search" button
    Then the system should display a list of domestic flights between New York and Los Angeles
    And the flight details should include:
      | Airline            |
      | Departure/arrival times |
      | Fare type          |
      | Layover information |