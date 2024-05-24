Feature: Buy book
  make a successful purchase of a book


  Background: Login Successfully
    Given I am on demoQa page
    When I submit username and password
    Then I should be logged in


  Scenario: Purchase Successfully
    Given I select a book at random
    When I validate the messages
    Then I delete book




