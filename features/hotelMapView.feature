Feature: View Hotels on Map

  Scenario: Display hotels on a map
    Given a search query has been executed
    And results are displayed
    When the user clicks on the "Map View" option
    Then a map is displayed with markers for all hotels within a 10-mile radius of the search location
    And each marker includes a tooltip with the hotel name, price, and rating