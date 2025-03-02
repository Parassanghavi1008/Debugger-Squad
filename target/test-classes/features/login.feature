Feature: Login flow check
  Scenario: login with valid credentials
    Given I am on the login page
    When I enter valid username & password
    And I click on the login button
    Then I should be redirected to the homepage