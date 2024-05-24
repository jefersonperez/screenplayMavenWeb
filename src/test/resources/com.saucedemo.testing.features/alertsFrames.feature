Feature: print in report
  print parent frame and child frame in report


  Background: Login Successfully
    Given I am on demoQa page
    When I submit username and password
    Then I should be logged in


  Scenario: print and forms succefully


  Given the user navigates to the Alerts, Frame & Windows module and selects Nested Frames
    Then the user extracts the text from Parent frame and chil iframe
    When the user navigates to the Practice Form module
    And the user fills the practice form with the following details
    And the user submits the form
    #Then the form should be submitted successfully