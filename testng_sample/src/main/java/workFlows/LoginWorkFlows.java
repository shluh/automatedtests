package workFlows;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginWorkFlows {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;

	public LoginWorkFlows(WebDriver driver) {
		this.driver = driver;
		this.homePage = new HomePage(driver);
		this.loginPage = new LoginPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
	}

	public void LoginValidationWithValidCredencials(String userName, String userEmail, String userPassword,
			String myAccountOption) {
		homePage.myAccountOptions(myAccountOption);
		Assert.assertTrue(loginPage.LoginPageDisplayed());
		loginPage.Login(userEmail, userPassword);
		Assert.assertTrue(myAccountPage.MyAccountPageDisplayed());
		Assert.assertTrue(myAccountPage.GetUsername().equals("Hi, " + userName));
	}

	public void LogOut(String userAccountOption) {
		myAccountPage.LogOut(userAccountOption);
	}

	public void LoginValidationWithInvalidCredencials(String userEmail, String userPassword, String myAccountOption) {
		homePage.myAccountOptions(myAccountOption);
		Assert.assertTrue(loginPage.LoginPageDisplayed());
		loginPage.Login(userEmail, userPassword);
		Assert.assertTrue(loginPage.LoginWithInvalidCredencials());
	}

}
