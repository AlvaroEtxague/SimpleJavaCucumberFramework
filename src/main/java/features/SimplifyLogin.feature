Feature: Simplify Login Page
  Description: This feature will test different logins on the Simplify Login Page

  @SmokeTest
  Scenario Outline: User with valid credential can login
    Given User is on Login Page
    When User enters a valid <username> and <password>
    Then User can click on login button

    Examples:
      | username  | password     |
      | validUser | validPass123 |