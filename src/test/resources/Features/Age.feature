Feature: Validate to ensure legal age feature is functioning as expected 
Background:
 Given user is on the Home Page "https://www.playtech.com/" 
Scenario: Validate legal age feature is functioning as expected
    When  user should enter legal age before entering the site 
    Then  user should be able to successfully enter into the homepage
Scenario: validate the page with invalid age 
When user enters invalid age for entering the site 
Then user should throw an error message 