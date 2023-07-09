package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;
import com.qa.util.ExcelReader;

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
	
	@Then("user verifies the set of products from sheetname {string} and rowNumber {int} from the list")
	public void user_verifies_the_set_of_products_from_sheet_and_rownumber_row_number_from_the_list(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> testData = excelReader
				.getData("/Users/udayabhaskar/Documents/eclipseWorkspace/CucumberLearnProject_Junit/TestData/ProductsExcel.xlsx", SheetName);
		String productName = testData.get(rowNumber).get("Product Name");
		List<String> li_Products = productsPage.getListOfProducts();
		Iterator<String> it = li_Products.iterator();
		boolean flag = false;
		while(it.hasNext()) {
			String product = it.next().trim();
			if( product.contains(productName)) {
				flag = true;
				break;
			}
		}
		Assert.assertEquals(true, flag);
		
		//boolean verifyProduct = productsPage.verifyProductsFromTheList(".TestData/ProductsExcel.xlsx","yy" );
	}
	


}
