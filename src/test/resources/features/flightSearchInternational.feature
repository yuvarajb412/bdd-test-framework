Feature: Verify International Flight Search

Scenario: Validate international flight search functionality
  Given the user is on the flight search page
  When the user enters "New York" as the origin and "London" as the destination
  And clicks the search button
  Then the system displays a list of international flights