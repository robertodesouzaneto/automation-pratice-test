package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	List<WebElement> listaProdutos = new ArrayList<WebElement>();

	private By buttonSignIn = By.className("header_user_info");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage clickButtonSignIn() {
		driver.findElement(buttonSignIn).click();
		return new SignInPage(driver);
	}

	
}
