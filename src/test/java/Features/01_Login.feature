Feature: Login

  Scenario: Test login functionality with valid credentials using outlook
    Given Getting started with mobile app
    When Login with valid credentials Outlook
    And Complete Welcome Screen steps
    Then Validate user Email is logged in boomerang
