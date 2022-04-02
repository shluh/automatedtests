package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserSetup extends ClasseBase {

	public static WebDriver ChromeDriver()
    {
		String driverPath = "drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		webDriver = new ChromeDriver();
		wait = new WebDriverWait(webDriver, 30);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return webDriver;
    }
	
	public static WebDriver FirefoxDriver(WebDriver webDriver,WebDriverWait wait)
    {
		String driverPath = "drivers/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		webDriver = new FirefoxDriver();
		wait = new WebDriverWait(webDriver, 30);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return webDriver;
    }

}
