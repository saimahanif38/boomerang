Feature: Settings

  Scenario Outline:  verify Theme changing from account settings
    Given Getting started with mobile app
    When Login with valid credentials "<email>" and "<password>" using outlook
    And Complete Welcome Screen steps
    Then go to menu bar and click on setting
    Examples:
      | email                        | password  |
      | saimahaniffolio3@outlook.com | recite786 |
