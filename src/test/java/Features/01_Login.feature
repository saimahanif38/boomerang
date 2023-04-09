Feature: Login

  Scenario:  Test login functionality with valid credentials
    Given user is on the mobile login page
    When Login with valid credentials
    Then Validate user is logged in
