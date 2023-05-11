Feature: Compose Mail

  Scenario: To test user is able to open compose email and meeting scheduled
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Click on compose email button and compose email screen is appeared
    And Add text for email and add participants
    And Add meeting schedule, title, guests, description, and title
    Then Validate success message