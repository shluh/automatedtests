package stepsdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.FormularioDeSimulacaoPage;
import utils.Enviroment;
import utils.TestsConfiguration;
import workflow.SimulacaoWorkflow;

public class StepDefinitions extends TestsConfiguration {
	private final WebDriver wdriver = new ChromeDriver();
	private FormularioDeSimulacaoPage formSimulacao = new FormularioDeSimulacaoPage(wdriver);
	private SimulacaoWorkflow swf = new SimulacaoWorkflow(driver);
	
	private String perfil;
	private double valorAplicar;
	private double valorPoupar;
	int qtde_Dia_Ano;
	String mes_Ano;
	
	public StepDefinitions(String perfil, double valorAplicar, double valorPoupar,int qtde_Dia_Ano, String mes_Ano ){
		this.perfil = perfil;
		this.valorAplicar = valorAplicar;
		this.valorPoupar = valorPoupar;
		this.qtde_Dia_Ano = qtde_Dia_Ano;
		this.mes_Ano = mes_Ano;
	}
	
	@Given("^A pagina de simulacao carregada $")
	public void a_pagina_de_simulacao_carregada() {
		driver.get(Enviroment.Simulacao);
	}

	@And("^eu sou um associado$")
	public void eu_sou_um_associado(){
		assertTrue(formSimulacao.InformePerfilSelecionado(perfil));
	}

	@When("preencho os valores abaixo para simular$")
	public void preencho_os_valores_abaixo_para_simular() {
		formSimulacao.SetValorAplicar(Double.toString(valorAplicar));
		formSimulacao.SetValorAplicar(Double.toString(valorPoupar));
		formSimulacao.SetQuantoTempoPoupar(Integer.toString(qtde_Dia_Ano), mes_Ano);
	}

	@And("clico no botao para simular$")
	public void clico_no_botao_para_simular(int qtde_Dia_Ano, String mes_Ano) {
		formSimulacao.Simular();
	}

	@Then("eu vejo a tabela de resultado com mes valor de opcoes para simular")
	public void eu_vejo_a_tabela_de_resultado_com_mes_valor_de_opcoes_para_simular() {
		swf.ExibeValorPoupadoBaseadoEmMeses();
	}
}
