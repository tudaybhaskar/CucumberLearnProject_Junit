package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {
	
	LoginPage loginPage;
	ProductsPage productsPage; 
	@Given("open browser with {string}")
	public void open_browser_with_url(String url) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Login page is displayed");
	}

	@When("user enters {string} and {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage();
		loginPage.setUserName(uname);
		loginPage.setPassword(pwd);
	}

	@And("click on signIn button")
	public void click_on_sign_in_button() {
	    // Write code here that turns the phrase above into concrete actions
	    loginPage.click_SignIn_Button();
	}

	@Then("user should be able to navigate to Products page")
	public void user_should_be_able_to_navigate_to_products_page() {
	    // Write code here that turns the phrase above into concrete actions
		productsPage = new ProductsPage();
	    productsPage.ProductsPageTitle();
	}


}
