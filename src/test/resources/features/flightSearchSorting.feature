Feature: Verify Sorting by Price

Scenario: Validate sorting functionality for flight results
  Given the user is on the flight search page
  When the user enters "New York" as the origin and "Los Angeles" as the destination
  And clicks the search button
  And the user sorts the results by price
  Then the system displays flights sorted by price