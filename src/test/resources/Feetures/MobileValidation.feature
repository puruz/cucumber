#Author: your.email@your.domain.com
Feature: Vivo Mobile Validation

  Scenario: HardCoded values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile
    And user click on the mobile name
    Then user validate the mobile names

  Scenario: HardCoded values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile by one dim list
      | vivo | iphone | samsung |
    And user click on the mobile name
    Then user validate the mobile names

  Scenario: HardCoded values
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile by one dim map
      | 1 | vivo  |
      | 2 | iphone  |
      | 3 | samsung |
    And user click on the mobile name
    Then user validate the mobile names
    
    Scenario Outline:
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile "<phone>"
    And user click on the mobile name
    Then user validate the mobile names
    
    Examples:
    |phone|
    |vivo|
    |iphone|
    |samsung|
   