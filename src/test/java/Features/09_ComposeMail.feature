Feature: Compose Mail

  Scenario: To test user is able to open compose email
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Click on compose email button and compose email screen is appeared
    Then Add text for email and add participants and validate success message