Feature: Login

  Scenario Outline:  Test login functionality with valid credentials using outlook
    Given Getting started with mobile app
    When Login with valid credentials "<email>" and "<password>" using outlook
    And Complete Welcome Screen steps
    Then Validate user is logged in boomerang
    Examples:
      | email                        | password  |
      | saimahaniffolio3@outlook.com | recite786 |
