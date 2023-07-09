package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.util.ExcelReader;

public class ProductsPage {
	
	private WebDriver driver;
	private ExcelReader excelReader = new ExcelReader();
	//1 By Locators
	private By pageContainerTitle = By.cssSelector(".header_secondary_container span.title");
	
	//2. constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//PageActions:
	public List<String> getListOfProducts() {
		List<WebElement> listOfProducts = driver.findElements(By.cssSelector("div.inventory_item_name"));
		List<String> li = new ArrayList<String>();
		for(WebElement e : listOfProducts) {
			System.out.println("Product name: " + e.getText());
			li.add(e.getText());
		}
		return li;
		
	}
	
	public int countOfProducts(List li) {
		return li.size();
		
	}
	
	public String getProductsPageTitle() {
		return driver.findElement(pageContainerTitle).getText();
	}
	
	
}
