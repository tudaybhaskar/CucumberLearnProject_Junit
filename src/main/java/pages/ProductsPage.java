package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	
	private WebDriver driver;
	//1 By Locators
	private By pageContainerTitle = By.cssSelector(".header_secondary_container span.title");
	
	//2. constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//PageActions:
	public String getPageContainerTitle() {
		return driver.findElement(pageContainerTitle).getText();
	}
	
	public void getListOfProducts() {
		System.out.println("List of Products is displayed");
	}
}
