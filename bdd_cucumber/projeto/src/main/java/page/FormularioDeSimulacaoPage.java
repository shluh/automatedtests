package page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioDeSimulacaoPage {
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	public FormularioDeSimulacaoPage(WebDriver webdriver) {
		this.webDriver = webdriver;
		this.wait = new WebDriverWait(webdriver, 60);
	}

	private By informeSeuPerfil = By
			.xpath("//div[contains(text(),'Informe seu perfil')]//ancestor::div[starts-with(@class, 'relative')]");

	private By valorAplicar = By.id("valorAplicar");
	private By valorInvestir = By.id("valorInvestir");
	private By formBloco = By.cssSelector(".conteudoBloco");
	private By quantoTempoPoupar = By.id("tempo");
	private By btnBlocoFormulario = By.cssSelector("[class^='btSelect'] .btn");
	private By blocoFormularioOpt = By.className("listaSelect");
	private By btnSimular = By.cssSelector(".btn.btnAmarelo.btnSimular");
	private By valorMinimoAplicar = By.id("valorAplicar-error");
	private By valorMinimoInvestir = By.id("valorInvestir-error");

	
	public boolean InformePerfilSelecionado(String perfil) {

		boolean checkboxSelected = false;
	
		Actions act = new Actions(webDriver);
		act.moveToElement(webDriver.findElement(formBloco));
		act.build().perform();
		
		WebElement perfils = webDriver.findElement(informeSeuPerfil);
		ArrayList<WebElement> options = (ArrayList<WebElement>) perfils.findElements(By.tagName("input"));

		for (WebElement web : options) {
			if (web.getAttribute("value").equalsIgnoreCase(perfil) && web.isSelected()) {
				checkboxSelected = true;
				break;
			}
		}

		return checkboxSelected;
	}

	public void SetValorAplicar(String valor) {
		webDriver.findElement(valorAplicar).sendKeys(valor);
	}

	public void SetValorPoupar(String valor) {
		webDriver.findElement(valorInvestir).sendKeys(valor);
	}

	public void SetQuantoTempoPoupar(String qtde, String mesAno) {
		webDriver.findElement(quantoTempoPoupar).sendKeys(qtde);
		webDriver.findElement(btnBlocoFormulario).click();

		WebElement option = webDriver.findElement(blocoFormularioOpt);
		ArrayList<WebElement> options = (ArrayList<WebElement>) option.findElements(By.tagName("li"));

		for (WebElement web : options) {
			if (web.getText().equals(mesAno)) {
				web.click();
				break;
			}
		}
	}
	
	public void Simular () {
		webDriver.findElement(btnSimular).click();
		
	}
	
	public String GetValorMinimoAplicar() {
		return webDriver.findElement(valorMinimoAplicar).getText();
	}
	
	public String GetValorMinimoInvestir() {
		return webDriver.findElement(valorMinimoInvestir).getText();
	}

}
