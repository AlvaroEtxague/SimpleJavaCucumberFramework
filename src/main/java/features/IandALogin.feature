Feature: I&A Login Page
  Description: This feature will test different logins on the I&A Login Page

  @SmokeTest
  Scenario Outline: User with valid credentials can login
    Given User is on I&A Login Page
    When User enters a valid <username> and <password>
    And User clicks on login button
    Then User is redirected to the Home page

    Examples:
      | username  | password     |
      | alvaro@gsmtest.com | Pa$$w0rd |