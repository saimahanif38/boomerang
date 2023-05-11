Feature: Inbox Paused And Unpause

  Scenario: To test inbox paused functionality
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Go to the menu bar and inbox pause
    And Change the auto-responder text
    And Set the unpause automatically
    Then Pause the inbox

  Scenario: To test inbox unpause functionality
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Go to the menu bar and inbox pause
    Then Unpause the inbox
