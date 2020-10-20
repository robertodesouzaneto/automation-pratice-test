package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	private WebDriver driver;
	
	private By emailCreateAccount = By.id("email_create");
	
	private By buttonCreateAccount = By.id("SubmitCreate");
	
	private By emailAlreadyRegistered = By.id("email");
	
	private By password = By.id("passwd");
	
	private By buttonSignIn = By.id("SubmitLogin");
	
	private By errorMessageSignIn = By.cssSelector("div.alert-danger ol li");
	
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillEmailCreateAccount(String email) {
		driver.findElement(emailCreateAccount).sendKeys(email);
	}
	
	public CreateAccountPage clickButtonCreateAccount() {
		driver.findElement(buttonCreateAccount).click();
		return new CreateAccountPage(driver);
	}
	
	public void fillEmailAlreadyRegistered(String email) {
		driver.findElement(emailAlreadyRegistered).sendKeys(email);
	}
	
	public void fillPassword(String text) {
		driver.findElement(password).sendKeys(text);
	}
	
	public AccountPage clickButtonSignIn() {
		driver.findElement(buttonSignIn).click();
		return new AccountPage(driver);
	}
	
	public String getErrorMessageSignIn() {
		return driver.findElement(errorMessageSignIn).getText();
	}
}
