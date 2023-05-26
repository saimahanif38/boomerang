Feature: Inbox Paused Feature

  Scenario: To test inbox paused functionality
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Go to the menu bar and inbox pause button
    And Change the auto-responder text
    And Set the unpause automatically and day
    And Pause the inbox
    And Validate that new folder is created for paused mails
    Then Validate that inbox is paused on the browser too and email received in the inbox Paused folder

  Scenario: To test inbox unpause functionality
    Given Getting started with mobile app
    When Login with valid credentials using outlook
    And Check inbox paused email from inbox
    And Go to the menu bar open new folder and check the email received in it
    And Go to the menu bar and inbox pause
    And Unpause the inbox
    And Validate mail paused email is removed now
    Then Validate the inbox-paused folder is removed, inbox pause mail is removed and new email moved in the inbox






























#  Scenario: To test user is able to open compose email and meeting scheduled
#    Given Getting started with mobile app
#    When Login with valid credentials using outlook
#    And Click on compose email button and compose email screen is appeared
#    And Add text for email and add participants
#    And Add meeting schedule, title, guests, description, and title
#    Then Validate success message