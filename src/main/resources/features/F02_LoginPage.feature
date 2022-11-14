@Test
Feature: Test The Login Page

  Background: to get in login page
    Given the user click on Account to login

  Scenario: the register user could be able to login with his valid data
    When the user enter his email
    And enter his valid password
    Then the user should be directed to the home page

  Scenario: the register user could not be able to login with invalid password
    When the user enter his email
    And enter invalid password
    Then an error message should be appear and can not be directed to home page


  Scenario: the register user could not be able to login with invalid email
    When the user enter his invalid email
    Then he will be directed to password page of registration


