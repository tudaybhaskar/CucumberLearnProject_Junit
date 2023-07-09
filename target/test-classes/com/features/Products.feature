Feature: Products page feature

Background: 
	Given user is on Products page
	|username|password|
	|standard_user|secret_sauce|
@Skip
Scenario: Products page title
	Given user is on Products Page
	When user gets the title of the page
	Then page title should contain name as "Products"
@Skip
Scenario: Get No of products from the list of Products
	Given user is on Products Page
	When user get the list of Products
	Then user finds count of products to be 6
	
Scenario Outline: Verify set of products are available in Products Page
	Given user is on Products Page
	When user get the list of Products
	Then user verifies the set of products from sheetname "<SheetName>" and rowNumber <RowNumber> from the list
	
	Examples:
		|SheetName|RowNumber|
		|ProductsPage|1|
		|ProductsPage|2|
		|ProductsPage|3|
		|ProductsPage|4|
		|ProductsPage|5|
		