package workflow;

import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import page.FormularioDeSimulacaoPage;
import page.PainelDeSimulacaoPage;

public class SimulacaoWorkflow {
	private WebDriver webdriver;
	private FormularioDeSimulacaoPage formSimulacao;
	private PainelDeSimulacaoPage painelSimulacao;

	public SimulacaoWorkflow(WebDriver webdriver) {
		this.webdriver = webdriver;
		this.formSimulacao = new FormularioDeSimulacaoPage(webdriver);
		this.painelSimulacao = new PainelDeSimulacaoPage(webdriver);
	}

	public void PreencherFormularioSimulacao(String perfil, double valorAplicar, double valorPoupar, int qtdeDiaAno,
			String mesAno) {

		assertTrue(formSimulacao.InformePerfilSelecionado(perfil));
		formSimulacao.SetValorAplicar(Double.toString(valorAplicar));
		formSimulacao.SetValorPoupar(Double.toString(valorPoupar));
		formSimulacao.SetQuantoTempoPoupar(Integer.toString(qtdeDiaAno), mesAno);
		formSimulacao.Simular();
	}

	public void ExibeValorPoupadoBaseadoEmMeses() {

		Map<String, String> painel = painelSimulacao.PainelDeSimulacao();

		String path = "projectdocs/poupancavalores.txt";
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		try {

			BufferedWriter arquivo = new BufferedWriter(new FileWriter(path, true));
			arquivo.write(painel.toString());
			arquivo.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void SimulacaoValoresMinimos(String perfil, double valorAplicar, double valorPoupar) {

		assertTrue(formSimulacao.InformePerfilSelecionado(perfil));
		formSimulacao.SetValorAplicar(Double.toString(valorAplicar));
		formSimulacao.SetValorPoupar(Double.toString(valorPoupar));
		new Actions(webdriver).sendKeys(Keys.TAB).build().perform();

		String mensagemdeValorMinimo = "Valor mínimo de 20.00";
		assertTrue(formSimulacao.GetValorMinimoAplicar().equals(mensagemdeValorMinimo)
				&& formSimulacao.GetValorMinimoInvestir().equals(mensagemdeValorMinimo));
	}

}
