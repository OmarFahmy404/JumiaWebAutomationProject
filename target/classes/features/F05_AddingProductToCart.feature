@Test
Feature: Testing the functionality of adding product to shopping cart

  Scenario: the logged user could be able to add an item to his shopping cart
    Given the user logged in successfully
    When the user select an item
    And add it to his shopping cart
    And select the more details about the item
    Then the success notification message should be appear
    And the product should be appear in shopping cart

