package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	//1.By locators : OR
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By signInButton = By.id("login-butto");
	
	//2. Constructor 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page actions
		public void setUserName(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	public void setPassword(String Password) {
		driver.findElement(password).sendKeys(Password);
	}
	
	public ProductsPage click_SignIn_Button() {
		driver.findElement(signInButton).click();
		return new ProductsPage(driver);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
}
