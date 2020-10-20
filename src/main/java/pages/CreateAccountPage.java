package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
	
	private WebDriver driver;
	
	private By titleMr = By.id("id_gender1");
	
	private By firstName = By.id("customer_firstname");
	
	private By lastName = By.id("customer_lastname");
	
	private By password = By.id("passwd");
	
	private By address = By.id("address1");
	
	private By city = By.id("city");
	
	private By state = By.id("id_state");
	
	private By postalCode = By.id("postcode");
	
	private By mobilePhone = By.id("phone_mobile");
		
	private By buttonRegister = By.id("submitAccount");
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillTitle() {
		driver.findElement(titleMr).click();
	}
	
	public void fillFirstName(String text) {
		driver.findElement(firstName).sendKeys(text);
	}
	
	public void fillLastName(String text) {
		driver.findElement(lastName).sendKeys(text);
	}
	
	public void fillPassword(String text) {
		driver.findElement(password).sendKeys(text);
	}
	
	public void fillAddress(String text) {
		driver.findElement(address).sendKeys(text);
	}
	
	public void fillCity(String text) {
		driver.findElement(city).sendKeys(text);
	}
	
	public Select findDropDownState() {
		return new Select(driver.findElement(state));
	}
	
	public void selectState(String option) {
		findDropDownState().selectByVisibleText(option);
	}

	public void fillPostalCode(String text) {
		driver.findElement(postalCode).sendKeys(text);
	}
	
	public void fillMobilePhone(String text) {
		driver.findElement(mobilePhone).sendKeys(text);
	}
	
	public AccountPage clickRegister() {
		driver.findElement(buttonRegister).click();
		return new AccountPage(driver);
	}
}
