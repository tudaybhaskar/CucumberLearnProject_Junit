package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ProductsPage productsPage;
	
	@Given("user is on Login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    title = loginPage.getPageTitle();
	    System.out.println("Page title : " + title);
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitleName) {
	    Assert.assertTrue(title.contains(expectedtitleName));
	}
	
	

	@When("user enters {string} and {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.setUserName(uname);
		loginPage.setPassword(pwd);
	}

	@And("click on signIn button")
	public void click_on_sign_in_button() {
	    // Write code here that turns the phrase above into concrete actions
	    productsPage = loginPage.click_SignIn_Button();
	    
	}

	@Then("user is on {string} Page")
	public void user_is_on_Products_Page(String expectedTitleName) {
	    // Write code here that turns the phrase above into concrete actions
		String p_title = productsPage.getProductsPageTitle();
		Assert.assertTrue(p_title.contains(expectedTitleName));
	}


}
