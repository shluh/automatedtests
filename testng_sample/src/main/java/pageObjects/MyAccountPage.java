package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private final By welcomeHeader = By.cssSelector("h3.RTL");
	private final By pageMyAccnoutReady = By.xpath("//body[@onload='startTime()' and @style='overflow: visible;']");
	private final By userLogoutToogle = By.cssSelector("#collapse  b.lightcaret.mt-2.go-left");
	private final By userAccountOptions = By.cssSelector("li.open li");
	private final By invice = By.xpath("//a[text()='Invoice']");

	public MyAccountPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 30);
	}

	public boolean MyAccountPageDisplayed() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pageMyAccnoutReady));
		return webDriver.getCurrentUrl().contains("account");
	}

	public String GetUsername() {
		return webDriver.findElement(welcomeHeader).getText();
	}

	public void LogOut(String userAccountOption) {
		webDriver.findElement(userLogoutToogle).click();
		ArrayList<WebElement> userLogoutOpt = (ArrayList<WebElement>) webDriver.findElements(userAccountOptions);
		for (WebElement web : userLogoutOpt) {
			if (web.getText().contains(userAccountOption)) {
				web.click();
				break;
			}
		}
	}
	
	public String SelectInvoice(int optionToSelect) {
		ArrayList<WebElement> invices = (ArrayList<WebElement>) webDriver.findElements(invice);
		return invices.get(optionToSelect).getAttribute("href");
	}

}
