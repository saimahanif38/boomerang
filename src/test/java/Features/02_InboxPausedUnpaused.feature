Feature: Validating Functionality Inbox Paused And Unpause

  Scenario: To test inbox paused functionality
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Go to the menu bar and inbox pause
    And Pause the inbox
    Then Validate inbox is paused now

  Scenario: To test inbox unpause functionality
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Go to the menu bar and inbox pause
    And Unpause the inbox
    Then Validate inbox is unpause now
