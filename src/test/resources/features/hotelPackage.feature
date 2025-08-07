Feature: Search Holiday Packages on MakeMyTrip

  Scenario: Search holiday packages from chennai to kerala
    Given user is on MakeMyTrip homepage with popup closed
    When user navigates to the Holiday Packages tab
    And user selects "chennai" as the From city
    And user selects "kerala" as the To city or category
    And user selects departure date after 10 days
    And user sets guests as "3 Adults, 1 Room"
    And user clicks the Search button
    Then holiday packages from chennai to kerala should be displayed
