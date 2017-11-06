Feature: As pet owner I want to add a product to the cart so that improves my pet happiness

  Background:
    Given an empty cart

  Scenario: add a product to the cart
    Given I am looking for a dog product
    When I add the product to the cart
    Then the product should be present in my cart