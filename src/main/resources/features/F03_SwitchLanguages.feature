@Test
Feature: Test the language change feature

  Scenario: the normal user should be able to change the language from English to Arabic
    When the user click on Arabic to change the language
    Then the website turn into Arabic

  Scenario: the normal user should be able to change the language from Arabic to English
    Given the user already selected an Arabic
    When the user click on English to change the language
    Then the website turn into English