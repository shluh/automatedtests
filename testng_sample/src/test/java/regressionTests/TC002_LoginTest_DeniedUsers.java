package regressionTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import dataprovider.PhpTravelUsersDP;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PHPTEnviornments;
import workFlows.LoginWorkFlows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC002_LoginTest_DeniedUsers {
	WebDriver driver;
	private LoginWorkFlows loginWorkFlows;
	
	@Test (dataProvider = "DeniedUsers", dataProviderClass = PhpTravelUsersDP.class)
	public void Login_InvalidCredentials(String userEmail, String userPassword) {
		driver.get(PHPTEnviornments.HOM);
		loginWorkFlows.LoginValidationWithInvalidCredencials(userEmail, userPassword, "Login");
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
