Feature: Settings

  Scenario: Test login functionality with valid credentials using outlook
    Given Getting started with mobile app
    When Login with valid credentials Outlook
    And Complete Welcome Screen steps
    Then go to menu bar and click on setting
