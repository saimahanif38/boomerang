Feature: Settings -> Set Name

  Scenario: Verify user name from settings
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    Then go to menu bar and click on Settings and click on Account Settings
    Then click on the name field and set the name
