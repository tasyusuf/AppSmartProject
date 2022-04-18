Feature: UI Menu Data Match with API
  Background:
    Given user is on the main page
  @wip
  Scenario: User Can See the Correct Menu Options After Clicking the Related Menu
    When user clicks "Nachos" on the menu table
    Then user see the below options related to Nachos menu
    |Nachos              |
    |Nachos Chili Cheese |
    |Nachos Chicken Style|
    |Nachos Diavolo      |
    And API response match with the below Nachos menu
      |Nachos              |
      |Nachos Chili Cheese |
      |Nachos Chicken Style|
      |Nachos Diavolo      |