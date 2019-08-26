Feature: Login

  Background:
    Given user is on the landing page


  Scenario: user login
    When user logs in as a hr
    Then user verifies that "NextbaseCRM" page name is displayed


  Scenario: Verify warning message for invalid credentials
    When user logs in with "wrong" username and "wrong" password
    And user verifies that "Incorrect login or password" warning message is displayed

