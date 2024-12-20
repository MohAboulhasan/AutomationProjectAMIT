Feature: login Feature

  Scenario: login with valid credentials

    Given user opens homepage and click on login link
    When user enter valid username and valid password and press login
    Then user is switched to SecureArea Page

    Scenario: login with invalid username
      Given user opens homepage and click on login link
      When user enter invalid username and valid password and press login
      Then error message is displayed

