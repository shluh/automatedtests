package workFlows;

import org.openqa.selenium.WebDriver;

import pageObjects.MyAccountPage;

public class MyAccountWorkFlows {
	private WebDriver driver;
	private MyAccountPage myAccountPage;
	
	public MyAccountWorkFlows(WebDriver driver) {
		this.driver = driver;
		this.myAccountPage = new MyAccountPage(driver);
	}
	
	public void SelectAndGoToFirstInvoicePage() {
		driver.get(myAccountPage.SelectInvoice(0));
	}

}
