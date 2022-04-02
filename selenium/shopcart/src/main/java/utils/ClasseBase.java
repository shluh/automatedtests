package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import workflows.SelecionaProdutoWorkFlows;

public class ClasseBase {
	protected static WebDriver webDriver;
	protected static WebDriverWait wait;
	protected SelecionaProdutoWorkFlows selecionaProduto;

	@BeforeClass
	public void beforeClass() {
		BrowserSetup.ChromeDriver();
		selecionaProduto = new SelecionaProdutoWorkFlows(webDriver);
		webDriver.get(Environment.ShopCart);
		
	}

	@AfterClass
	public static void tearDown() {
		webDriver.close();
	}

}
