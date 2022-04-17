Feature: Purchase function

  Background:
    Given user is on the main page

  Scenario: User add some products to Shopping Cart
    When user clicks "Burger" on the menu table
    And user click "Hamburger" tab
    And user choose pickup option from open popup and confirm
    And user clicks confirm button from product pop-up
    Then product added to shopping cart
  @wip
  Scenario: Discount must be implemented to product in total price
    When user clicks "Nachos" on the menu table
    And user click "Nachos Chicken Style" tab
    Then product added to shopping cart
    And total price is calculated with discount