package page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PainelDeSimulacaoPage {
	
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	public PainelDeSimulacaoPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 30);
	}

	private By tableRows = By.cssSelector(".maisOpcoes td");

	public Map<String, String> PainelDeSimulacao() {
		
		Map<String, String> map = new HashMap<String, String>();
		//ArrayList<WebElement> rows = (ArrayList<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableRows));
		ArrayList<WebElement> rows = (ArrayList<WebElement>) webDriver.findElements((tableRows));
		
		for (int i = 0; i < rows.size(); i += 2 ) {
			map.put(rows.get(i).getText(), rows.get(i + 1).getText());
		}

		return map;
	}

}
