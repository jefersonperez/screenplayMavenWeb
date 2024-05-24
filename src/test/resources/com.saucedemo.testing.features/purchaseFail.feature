Feature: Buy fail book
  make a fail purchase of a book


  Background: Login Successfully
    Given I am on demoQa page
    When I submit username and password
    Then I should be logged in


  Scenario: Purchase failed
    Given I select a non existent book


