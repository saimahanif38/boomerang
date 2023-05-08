Feature: Validating Functionality of Inbox Feature

  Scenario: To test user is able to open compose email
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Click on compose email button
    Then Validate compose email screen is appeared

  Scenario: To test inbox functionality
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Add text for email and add participants
    Then validate success message of email sent

