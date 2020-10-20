package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	
	private WebDriver driver;
	
	private By userInfo = By.cssSelector("div.header_user_info .account");
	
	private By buttonSignOut = By.className("logout");
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUserInfo() {
		return driver.findElement(userInfo).getText();
	}
	
	public SignInPage clickButtonSignOut() {
		driver.findElement(buttonSignOut).click();
		return new SignInPage(driver);
	}
	
}
