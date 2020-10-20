package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import base.BaseTests;
import pages.CreateAccountPage;
import pages.SignInPage;
import pages.AccountPage;
public class HomePageTests extends BaseTests {
	
	
	SignInPage signInPage;
	CreateAccountPage createAccountPage;
	AccountPage accountPage;
	
	String uuid = UUID.randomUUID().toString();

	String email = "test" + uuid + "@test.com";

	String password = "123456";
	
	String firstName = "John";
	
	String lastName = "Lennon";
	
	String address = "350 P O Davis Dr";
	
	String city = "Auburn";
	
	String state = "Alabama";
	
	String postalCode = "36801";
	
	String mobilePhone = "+1 334-203-2052";
	
	@Test
	public void testCreateAccount() {
		loadHomePage();
		
		signInPage = homePage.clickButtonSignIn();
		
		signInPage.fillEmailCreateAccount(email);
		
		createAccountPage = signInPage.clickButtonCreateAccount();
		
		createAccountPage.fillTitle();
		
		createAccountPage.fillFirstName(firstName);
		
		createAccountPage.fillLastName(lastName);
		
		createAccountPage.fillPassword(password);
		
		createAccountPage.fillAddress(address);
		
		createAccountPage.fillCity(city);
		
		createAccountPage.selectState(state);
		
		createAccountPage.fillPostalCode(postalCode);
		
		createAccountPage.fillMobilePhone(mobilePhone);
		
		accountPage = createAccountPage.clickRegister();
		
		String userInfo = accountPage.getUserInfo();
		
		assertThat(userInfo, is(firstName + " " + lastName));
	}
	
	@Test
	public void testLoginSucessful() {
		testCreateAccount();
		
		signInPage = accountPage.clickButtonSignOut();
		
		signInPage.fillEmailAlreadyRegistered(email);
		
		signInPage.fillPassword(password);
		
		accountPage = signInPage.clickButtonSignIn();
		
		String userInfo = accountPage.getUserInfo();
		
		assertThat(userInfo, is(firstName + " " + lastName));
	}
	
	@Test
	public void testLoginUncessful() {
		testLoginSucessful();
		
		signInPage = accountPage.clickButtonSignOut();
		
		signInPage.clickButtonSignIn();
		
		String errorMessageSignIn = signInPage.getErrorMessageSignIn();
		
		assertThat(errorMessageSignIn, is("An email address required."));
	}

}
