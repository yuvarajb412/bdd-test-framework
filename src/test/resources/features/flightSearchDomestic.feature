Feature: Verify Domestic Flight Search

Scenario: Validate domestic flight search functionality
  Given the user is on the flight search page
  When the user enters "New York" as the origin and "Los Angeles" as the destination
  And clicks the search button
  Then the system displays a list of domestic flights