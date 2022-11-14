@Test
Feature: Testing the functionality of removing product from shopping cart

  Scenario: the logged user could be able to remove an item from his shopping cart
    Given the logged user have already added a product to his shopping cart
    When the user remove the product which he added
    Then the shopping cart should be empty