package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	
	private WebDriver driver;
	//1 By Locators
	private By pageContainerTitle = By.cssSelector(".header_secondary_container span.title");
	
	//2. constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//PageActions:
	public List getListOfProducts() {
		List<WebElement> listOfProducts = driver.findElements(By.cssSelector("div.inventory_item_name"));
		for(WebElement e : listOfProducts) {
			System.out.println("Product name: " + e.getText());
		}
		return listOfProducts;
		
	}
	
	public int countOfProducts(List li) {
		return li.size();
		
	}
	
	public String getProductsPageTitle() {
		return driver.findElement(pageContainerTitle).getText();
	}
}
