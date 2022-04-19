@wip
Feature: Purchase function

  Background:
    Given user is on the main page
 # @smoke
  Scenario: User add some products to Shopping Cart
    When user clicks "Burger" on the menu table
    And user click "Hamburger" tab
    And user choose pickup option from open popup and confirm
    And user clicks confirm button from product pop-up
    Then product added to shopping cart

  Scenario: Discount must be implemented to product in total price
    When user clicks "Nachos" on the menu table
    And user click "Nachos Chicken Style" tab
    And user choose pickup option from open popup and confirm
   # And user clicks confirm button from product pop-up
    Then product added to shopping cart
    And total price is calculated with discount

  Scenario: User Checkout and See the Payment Board Successfully
    When user clicks "Popcorn" on the menu table
    And user click "Popcorn, Karamel" tab
    And user choose pickup option from open popup and confirm
    And user clicks confirm button from product pop-up
    Then product added to shopping cart
    And total price is calculated with discount
    When user clicks Order Now button
    And Address & personal details cart is opened
    And user fill the cart with personal information
    And clicks checkout
    Then user see the payment options