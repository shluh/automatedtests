package regressionTests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import dataprovider.PhpTravelUsersDP;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PHPTEnviornments;
import workFlows.LoginWorkFlows;

public class TC001_LoginTest_AllowedUsers {
	WebDriver driver;
	private LoginWorkFlows loginWorkFlows;
	
	@Test (dataProvider = "AllowedUsers", dataProviderClass = PhpTravelUsersDP.class)
	public void Login_ValidCredentials(String user, String email, String password ) {
		driver.get(PHPTEnviornments.HOM);
		loginWorkFlows.LoginValidationWithValidCredencials(user, email, password, "Login");
		loginWorkFlows.LogOut("Logout");
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginWorkFlows = new LoginWorkFlows(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
