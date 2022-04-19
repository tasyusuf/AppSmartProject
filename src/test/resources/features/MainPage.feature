#4.	Feature File it is a Cuscumber framework where
# my feature files hold the BDD scenarios,
#which are created using Gherkin language
@wip
Feature: Main Page features

  Background:
    Given user is on the main page

  Scenario: User Can Select the Language
    When user clicks the language abbreviation on the main page
    And user see the language options dropdown with options below
      |Deutsch DE |
      |English EN |
      |Polski PL  |
      |Česky CS   |
    Then user choose the language
    And language abbreviation changes

  Scenario: User Can See the Menu Headers
    When user see the menu options below
      |Angebote             |
      |American Burger      |
      |American Big Burger  |
      |Burger               |
      |Chicken-Burger       |
      |Vegetarian Burger    |
      |Finger Food          |
      |Special Box          |
      |Fries & Sides        |
      |Dips & Sauce         |
      |Hot Dogs             |
      |Wraps                |
      |Nachos               |
      |Maiskolben           |
      |Pizzabrot            |
      |Pizza                |
      |Pasta                |
      |Popcorn              |
      |Dessert              |
      |Salate               |
      |Muffins              |
      |Eis Cream            |
      |Getränke             |


  Scenario: User can click the Angebote and see the campaigns
    When user clicks "Angebote" on main menu table
    Then menu title displays Angebote

  Scenario: User can click the Getränke and see the drinks
    When user clicks "Getränke" on main menu table
    Then menu title displays Getränke | Alkoholfrei

  Scenario Outline: User can click the four section under Getränke menu <desiredSection>
    When user clicks "Getränke" on main menu table
    Then menu title displays Getränke | Alkoholfrei
    And user clicks the "<desiredSection>" tab
    Then menu title contains "<desiredSectionTitle>"
    Examples:
      |desiredSection       |desiredSectionTitle   |
      |Alkoholfrei          |Alkoholfrei           |
      |Bier                 |Bier                  |
      |Weine                |Weine                 |
      |Spirituosen          |Spirituosen           |

  Scenario Outline: User can click a menu and see the foods under <desiredFoodMenu>
    When user clicks "<desiredFoodMenu>" on the menu table
    Then the title displays "<desiredFoodTitle>"
    Examples:
      |desiredFoodMenu      |desiredFoodTitle   |
      |American Burger      |American Burger      |
      |American Big Burger  |American Big Burger  |
      |Burger               |Burger               |
      |Chicken-Burger       |Chicken-Burger       |
      |Vegetarian Burger    |Vegetarian Burger    |
      |Finger Food          |Finger Food          |
      |Special Box          |Special Box          |
      |Fries & Sides        |Fries & Sides        |
      |Dips & Sauce         |Dips & Sauce         |
      |Hot Dogs             |Hot Dogs             |
      |Wraps                |Wraps                |
      |Nachos               |Nachos               |
      |Maiskolben           |Maiskolben           |
      |Pizzabrot            |Pizzabrot            |
      |Pizza                |Pizza                |
      |Pasta                |Pasta                |
      |Popcorn              |Popcorn              |
      |Dessert              |Dessert              |
      |Salate               |Salate               |
      |Muffins              |Muffins              |
      |Eis Cream            |Eis Cream            |

  #@smoke
  Scenario Outline: Search function with valid products
    When user search a desired "<desiredProduct>"
    Then search result is shown for "<desiredProduct>"
    Examples:
      |desiredProduct|
      |Burger        |
      |Pizza         |
      |chicken       |


  Scenario Outline: Search function with invalid products
    When user search a desired "<desiredProduct>"
    Then search result is shown for "<desiredProduct>"
    And "Sorry, no products were found." message is displayed
    And Reset Search button is displayed

    Examples:
      |desiredProduct|
      |bmw           |
      |Pencil        |
      |shirt         |






