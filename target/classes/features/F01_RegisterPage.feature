@Test
Feature: Test The Register Page

  Background: to get in the register page
    Given the user click on Account to register


  Scenario: the user should not be able to register with invalid email
    When the user enter invalid email
    Then the email border should turn into red


  Scenario: the user should not be able to set password with numbers only
    When the user enter his valid email
    And enter only numbers as a password
    Then the password word should turn into red

  Scenario: the user should not enter the different password in second field
    When the user enter his valid email
    And enter his first valid password
    And enter a different password in second field
    Then an error message should be appear


  Scenario: the user should not be able to register with invalid names (numbers or one char) and invalid phone number (characters)
    When the user enter his valid email
    And enter his first valid password
    And enter his second valid password
    And enter numbers in first ,middle and last name and characters in phone no
    Then error messages should be appear under each field

  Scenario: the user should not be able to register with invalid phone number (less than 10 no)
    When the user enter his valid email
    And enter his first valid password
    And enter his second valid password
    And enter his first,middle,last name
    And enter less than 10 numbers in phone field
    Then an error message should be appear To inform the user


  Scenario: the normal user should be able to register with his valid data
    When the user enter his valid email
    And enter his first valid password
    And enter his second valid password
    And enter his first,middle,last name
    And enter his phone number
    And enter his gender and his birthdate
    Then after escaping the pin page the user should be directed to the home page


