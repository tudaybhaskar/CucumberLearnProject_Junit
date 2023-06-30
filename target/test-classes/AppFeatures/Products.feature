Feature: In products page, to verify list of products and a particular products exists or not 
	finally adding product to a cart.
	
	Background: 
		Given open browser with url
		And user enter username and password
		And user clicks on SignIn button
		And user navigates to Products Page
		
	Scenario: Verify a product is available in Products Page
		Given user is at Products page
		And get the list of products
		Then verify a product is available
		