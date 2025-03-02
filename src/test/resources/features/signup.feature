Feature: SignUp flow check
  Scenario: Signup with valid credentials
    Given I am on the signup page
    When I enter valid username and password
    And I click on the signup button
    Then I should be redirected to the dashboard
