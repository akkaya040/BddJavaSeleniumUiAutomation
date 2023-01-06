@MercedesHepsiburadaScenarios
Feature: Mercedes Automation Scenarios


  Background:
    Given User Navigates To "https://www.hepsiburada.com"
    When User Clicks Login Button In Main Page
    Then The User Should Arrive "Login" Page
    When User Logins With Credentials "wafebe8669@cnxcoin.com" "Test123456"

  @severity=normal
  @LoginAndAddProductToBasket
  Scenario: Adding Product Then Increase In Basket
    And User Search "laptop" In Main Page
    Then User Add Product Which Is On The Line 1
    Then User Add Product Which Is On The Line 3
    And User Goes Basket Page
    When User Increases The Count Of Product
    Then User Confirms Increment
    And User Goes Home Page
    Then User Logouts

  @UpdateUserBirthday
  Scenario: Update User Birthday
    When User Clicks User Information Button
    Then User Should See User Information Page
    When User Updates Birthday Info
    Then User Confirm Updated Birthday
    And User Logouts


