Feature: Product Search
  Scenario: Choose a product
    Given I am on the homepage
    When I am login to my account
    Then I am click on product & add to cart
    Then I click another product and add to cart
    Then I visit the cart and check total price
    Then I remove one product
    Then I check the cart total again