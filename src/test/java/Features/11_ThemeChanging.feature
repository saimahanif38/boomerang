Feature: Settings

  Scenario: Verify theme changing from settings
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    Then go to menu bar and click on Settings and click on Account Settings
    Then click on the Theme button to select the Theme and save it, after selection
