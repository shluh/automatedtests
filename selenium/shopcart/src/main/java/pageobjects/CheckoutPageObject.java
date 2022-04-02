package pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPageObject {
	private WebDriver webDriver;
	private WebDriverWait wait;

	public CheckoutPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 30);
	}

	private final By itensPainel = By.cssSelector(".sc-fAjcbJ.iSUOtU");
	private final By finalizarCompra = By.id("finish-checkout-button");
	private final By compraFinalizadaComSucesso = By.cssSelector(".sc-dNLxif.jyncPa");
	private final By botaoFechar = By.cssSelector(".sc-hqyNC.kgxKp button");

	public void AdicionarUnidades(String item, int qteItensAdicionar) {
		wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(itensPainel)));
		
		By qtdeDeItens = By.xpath("//div[contains(text(),'" + item +"')]/ancestor::div[@class='sc-Rmtcm kEGQm']/div/p");
		By adicionarBotao = By.xpath("//div[contains(text(),'" + item + "')]/ancestor::div[@class='sc-Rmtcm kEGQm']/div/div[starts-with(@id,'add')]");
		int validaQtdeAntes = Integer.parseInt(webDriver.findElement(qtdeDeItens).getText());
		
		for (int i = 0; i < qteItensAdicionar; i++) {
			webDriver.findElement(adicionarBotao).click();
		}
		
		int validaQtdeDepois = Integer.parseInt(webDriver.findElement(qtdeDeItens).getText());
		assertTrue(validaQtdeDepois == (validaQtdeAntes+qteItensAdicionar));
	}

	public void RemoverUnidades(String item, int qteItensRemover) {
		wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(itensPainel)));
		
		By qtdeDeItens = By.xpath("//div[contains(text(),'" + item +"')]/ancestor::div[@class='sc-Rmtcm kEGQm']/div/p");
		By removerBotao = By.xpath("//div[contains(text(),'" + item	+ "')]/ancestor::div[@class='sc-Rmtcm kEGQm']/div/div[starts-with(@id,'remove')]");
		int validaQtdeAntes = Integer.parseInt(webDriver.findElement(qtdeDeItens).getText());
		
		for (int i = 0; i < qteItensRemover; i++) {
			webDriver.findElement(removerBotao).click();
		}
		
		int validaQtdeDepois = Integer.parseInt(webDriver.findElement(qtdeDeItens).getText());
		assertTrue(validaQtdeDepois == (validaQtdeAntes-qteItensRemover));
	}

	public WebElement FinalizarCompraBotao() {
		return webDriver.findElement(finalizarCompra);
	}

	public Boolean CompraFinalizadaComSucesso() {
		return webDriver.findElement(compraFinalizadaComSucesso).isDisplayed();
	}

	public WebElement BotaoFechar() {
		return webDriver.findElement(botaoFechar);
	}

}
