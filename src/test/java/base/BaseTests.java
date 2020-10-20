package base;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseTests {

	private static WebDriver driver;
	protected HomePage homePage;

	@BeforeAll
	public static void start() {
		System.setProperty("webdriver.chrome.driver",
				"/home/roberto.neto/web-test/automation-pratice-test/src/test/resources/webdrivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeEach
	public void loadHomePage() {
		driver.get("http://automationpractice.com/index.php");
		homePage = new HomePage(driver);
	}
	

	@AfterAll
	public static void finish() {
		driver.quit();
	}

}
