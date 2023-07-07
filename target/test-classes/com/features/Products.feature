Feature: Products page feature

Background: 
	Given user is on Products page
	|username|password|
	|standard_user|secret_sauce|
	
Scenario: Products page title
	Given user is on Products Page
	When user gets the title of the page
	Then page title should contain name as "Products"
	
Scenario: Get No of products from the list of Products
	Given user is on Products Page
	When user get the list of Products
	Then user finds count of products to be 6