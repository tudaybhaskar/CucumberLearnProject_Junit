package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsPageSteps {
	
	private ProductsPage productsPage;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String pageContainerTitle;
	private List li;
	
	@Given("user is on Products page")
	public void user_is_on_products_page(DataTable dataTable) {
		List<Map<String,String>> credMaps = dataTable.asMaps();
		String username = credMaps.get(0).get("username");
		String password = credMaps.get(0).get("password");
		
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
		
		productsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Products Page")
	public void user_is_on_products_page() {
		pageContainerTitle = productsPage.getProductsPageTitle();
	    
	}

	@When("user get the list of Products")
	public void user_get_the_list_of_products() {
		li = productsPage.getListOfProducts();
	    
	}
	@Then("page title should contain name as {string}")
	public void page_title_should_contain_name_as(String expectedTitleName) {
		Assert.assertTrue(pageContainerTitle.contains(expectedTitleName));
	}

	@Then("user finds count of products to be {int}")
	public void user_finds_count_of_products_to_be(Integer int1) {
	    Assert.assertTrue(productsPage.countOfProducts(li) == int1);
	}


}
