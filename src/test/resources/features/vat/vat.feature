Feature: VAT Calculation

  @ok
  Scenario: Spanish general VAT
    Given I have a VAT calculator
    When tax is calculated for "diapers" with 100 price
    Then the result should be 121

  @ok
  Scenario: Spanish super reduced rate VAT
    Given I have a VAT calculator
    When tax is calculated for "bread" with 100 price
    Then the result should be 104

  @ok
  Scenario: Spanish reduced rate VAT
    Given I have a VAT calculator
    When tax is calculated for "wine" with 100 price
    Then the result should be 110

  @ko
  Scenario: Product with non-existent rate VAT
    Given I have a VAT calculator
    When tax is calculated for "panizo" with 100 price
    Then the product rate is not found