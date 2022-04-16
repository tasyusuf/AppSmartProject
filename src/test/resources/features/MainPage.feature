Feature: Main Page features

  Background:
    Given user is on the main page
@wip
  Scenario: User Can Select the Language
    When user clicks the language abbreviation on the main page
    And user see the language options dropdown with options below
      |Deutsch DE |
      |English EN |
      |Polski PL  |
      |Česky CS   |

    Then user choose the language
    And language abbreviation changes




