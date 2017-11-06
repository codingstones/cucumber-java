Feature: VAT Calculation

  Background:
    Given I have a VAT calculator

  @ok
  Scenario: Spanish general VAT
    When tax is calculated for "diapers" with 100 price
    Then the result should be 121

  @ok
  Scenario: Spanish super reduced rate VAT
    When tax is calculated for "bread" with 100 price
    Then the result should be 104

  @ok
  Scenario: Spanish reduced rate VAT
    When tax is calculated for "wine" with 100 price
    Then the result should be 110

  @ok
  Scenario Outline: Spanish no-general VAT
    When tax is calculated for "<product>" with <price> price
    Then the result should be <result>

    Examples:
      | product | price | result |
      |  bread  |  100  |  104   |
      |  wine   |  100  |  110   |


  @ko
  Scenario: Product with non-existent rate VAT
    When tax is calculated for "panizo" with 100 price
    Then the product rate is not found