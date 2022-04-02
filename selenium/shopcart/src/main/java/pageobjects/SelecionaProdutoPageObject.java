package pageobjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelecionaProdutoPageObject {
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	
	public SelecionaProdutoPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 30);
	}

	private final By selecionaCategoriaBotao = By.cssSelector(".sc-iAyFgw.mBXxg");
	private final By selecionaCategoria = By.cssSelector(".sc-eNQAEJ.bBoBAk li");
	private final By opcoesCategoria = By.cssSelector(".sc-VigVT.fjJcfV li h1");
	private final By adicionarAoCarrinhoBotoes = By.cssSelector(".sc-gZMcBi.gPZwOR");
	private final By botaoCarrinho = By.cssSelector(".sc-kGXeez.brMovy");
	
	
	public WebElement SelecionaCategoriaBotao() {
		return webDriver.findElement(selecionaCategoriaBotao);
	}
	
	public List<WebElement> SelecionaCategoria() {
		List<WebElement> opcoes = webDriver.findElements(selecionaCategoria);
		return opcoes;
	}
	
	private List<WebElement> OpcoesCategoria() {
		List<WebElement> opcoes = webDriver.findElements(opcoesCategoria);
		return opcoes;
	}
	
	private List<WebElement> OpcoesCategoriaAdicionarAoCarrinho() {
		List<WebElement> opcoes = webDriver.findElements(adicionarAoCarrinhoBotoes);
		return opcoes;
	}

	public void AdicionarTodosProdutoAoCarrinho() {
		for (int i = 0; i < OpcoesCategoria().size(); i++) {
			OpcoesCategoriaAdicionarAoCarrinho().get(i).click();

			By toast = By.xpath("//div[text()=\"O produto '" + OpcoesCategoria().get(i).getText()+"' foi adicionado ao carrinho\"]");
			wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(toast)));

			assertTrue(webDriver.findElement(toast).isDisplayed());
		}
	}
	
	public void AdicionarProdutoEspecificoAoCarrinho(String produto) {
		
		for (int i = 0; i < OpcoesCategoria().size(); i++) {
			if(OpcoesCategoria().get(i).getText().equals(produto)) {
				OpcoesCategoriaAdicionarAoCarrinho().get(i).click();

				By toast = By.xpath("//div[text()=\"O produto '" + OpcoesCategoria().get(i).getText()+ "' foi adicionado ao carrinho\"]");
				wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(toast)));

				assertTrue(webDriver.findElement(toast).isDisplayed());
				break;
			}
			
		}
	}
	
	
	public WebElement BotaorCarrinho() {
		return webDriver.findElement(botaoCarrinho);
	}

}
