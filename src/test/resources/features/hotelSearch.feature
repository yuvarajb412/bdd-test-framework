Feature: Hotel Search on MakeMyTrip

  Scenario: Search hotels in Goa for given dates
    Given user is on MakeMyTrip homepage with popup closed
    When user navigates to the Hotels tab
    And user enters "Goa" as the destination
    And user selects check-in and check-out dates
    And user clicks on the Search Hotels button
    Then available hotels in Goa should be listed
