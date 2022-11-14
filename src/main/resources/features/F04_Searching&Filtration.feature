@Test
Feature: Testing The Searching and Filtration Function

  Scenario: the normal or logged user could be able to search for any product by its name and make a filtration by price on it
    When the user searching for a product "Apple Watch"
    And make a filtration to select an Apple watch with 10230 EGP
    Then the product that will appear should be an apple watch

  Scenario: the normal or logged user could be able to search for any product by its SKU
    When the user searching for a product "ap848cl1n7so4nafamz"
    Then the product that will appear should be an apple mac pro 13

