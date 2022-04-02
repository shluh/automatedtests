package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private final By myaccountOption = By.cssSelector("#collapse #li_myaccount");
	private final By pageReady = By.xpath("//div[@id='preloader' and @style ='display: none;']");

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 30);
	}

	public void myAccountOptions(String optionToSelect) {
		WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(myaccountOption));
		myAccount.click();

		ArrayList<WebElement> myAccountOpt = (ArrayList<WebElement>) myAccount.findElements(By.tagName("a"));
		for (WebElement web : myAccountOpt) {
			if (web.getText().equals(optionToSelect)) {
				web.click();
				break;
			}
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(pageReady));
	}


}
