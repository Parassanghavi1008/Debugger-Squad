Feature: CheckOut process check
  Scenario: checkout products
    Given I am on homepage
    When I add products to the cart
    Then I go to cart & click on purchase
    Then I give details
    Then I successfully purchased