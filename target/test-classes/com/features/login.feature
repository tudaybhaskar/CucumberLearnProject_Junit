@Skip
Feature: Verify Login Feature
	@Skip
	Scenario: Login page title
	Given user is on Login page
	When user gets the title of the page
	Then page title should be "Swag Labs"
  @Skip
  Scenario: Valid user should be able to Login
    Given user is on Login page
    When user enters "standard_user" and "secret_sauce"
    And click on signIn button
    Then user is on "Products" Page

