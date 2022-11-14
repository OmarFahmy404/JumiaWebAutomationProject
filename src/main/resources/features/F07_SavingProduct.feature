@Test
Feature: Testing the functionality of saving an item in wishlist

  Scenario: the logged user could be able to save an item in his wishlist
    Given the user logged in successfully
    When the user select an item
    And add it to his wishlist
    Then the success wishlist notification message should be appear
    And the product should be appear in his wishlist
