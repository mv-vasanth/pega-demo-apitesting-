Feature: Update customer case type

  @regression
  Scenario: Update existing customer profile
    Given A new update customer case type
    When I look for a customer with ID "51425410D"
    Then The customer profile will found
    And I update the email address with "elvad@pega.com"
    Then The customer profile will be updated

  @regression
  Scenario: Customer profile not found
    Given A new update customer case type
    When I look for a customer with ID "789123654F"
    Then The customer profile will not found