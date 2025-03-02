Feature: Invalid signup check
  Scenario: Signup with duplicate data
    Given I am on the Homepage
    When I click on Signup & give duplicate data
    Then Error message show
    Then I am unable to signup