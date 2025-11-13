@Purchase
Feature: Purchase flow in SauceDemo
  As a SauceDemo user
  I want to complete a full purchase
  To validate the end-to-end process

  @Smoke
  Scenario: Successful purchase of two products
    Given the user navigates to the SauceDemo page
    When the user authenticates with valid credentials
    And adds two products to the cart
    And views the shopping cart
    And completes the purchase form with their data
    And finalizes the purchase
    Then should see the confirmation message "Thank you for your order!"