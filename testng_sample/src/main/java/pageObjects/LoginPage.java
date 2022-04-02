package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private final By emailField = By.xpath("//input[@type='email' and @name='username']");
	private final By passwordField = By.xpath("//input[@type='password' and @name='password']");
	private final By loginButton = By.cssSelector(".btn.btn-action.btn-lg.btn-block.loginbtn");
	private final By loginPanel = By.cssSelector(".panel-heading");
	private final By InvalidUserAlert = By.cssSelector("div.resultlogin .alert.alert-danger");

	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 30);
	}

	public boolean LoginPageDisplayed() {
		return webDriver.findElement(loginPanel).isDisplayed();
	}

	public void Login(String userEmail, String userPassword) {
		webDriver.findElement(emailField).sendKeys(userEmail);
		webDriver.findElement(passwordField).sendKeys(userPassword);
		webDriver.findElement(loginButton).click();
	}
	
	public boolean LoginWithInvalidCredencials() {
		if (LoginPageDisplayed()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated((InvalidUserAlert)));
			return true;
		}
		return false;
	}

}
