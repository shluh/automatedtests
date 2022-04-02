package regressionsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataprovider.InvestimentoPoupancaDP;
import utils.Enviroment;
import utils.TestsConfiguration;
import workflow.SimulacaoWorkflow;

public class TC001_SimulaPoupanca extends TestsConfiguration {
	SimulacaoWorkflow swf;

	@Test(dataProvider = "InvestimentoPoupanca", dataProviderClass = InvestimentoPoupancaDP.class)
	public void SimulaPoupanca(String informeSeuPerfil, double valorAplicar, double valorPoupar, int qtdeDiaAno,
			String mesAno) {
		driver.get(Enviroment.Simulacao);
		swf.PreencherFormularioSimulacao(informeSeuPerfil, valorAplicar, valorPoupar, qtdeDiaAno, mesAno);
		swf.ExibeValorPoupadoBaseadoEmMeses();
	}

	@Test(dataProvider = "ValorMinimo", dataProviderClass = InvestimentoPoupancaDP.class)
	public void SimulaPoupancaValoresMinimos(String informeSeuPerfil, double valorAplicar, double valorPoupar) {
		driver.get(Enviroment.Simulacao);
		swf.SimulacaoValoresMinimos(informeSeuPerfil, valorAplicar, valorPoupar);
	}

	@BeforeMethod
	public void config() {
		swf = new SimulacaoWorkflow(driver);
	}
}
