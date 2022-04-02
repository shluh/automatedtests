@SimulacaoInvestimentoPoupanca
Feature: Simular Investimento
  Com o proposito de Simular um Investimento na Poupanca
	como um Associado,
	eu gostaria de preencher o formulario de simulacao
	e ver a tabela de resultado com mes e Valor.

	Background: 
    Given Eu sou um associado
    Then gostaria de fazer uma simulacao de poupança
    And ver a tabela de resultado com mes e Valor.


  @SimulacaoPoupanca
  Scenario: Simulacao Poupanca
    Given A pagina de simulacao carregada 
    And eu sou um associado
    When preencho os valores abaixo para simular
    | valor_aplicar  | valor_poupar | qtde_Dia_Ano  | mes_Ano |
    | 1500.0				 | 500.0 				| 5						  | Ano			|
    And clico no botao para simular
    Then eu vejo a tabela de resultado com mes valor de opcoes para simular
    

  @ValoresMinimosSimulacao
  Scenario Outline: Valores Minimos Simulacao 
    Given A pagina de simulacao carregada
    And eu sou um associado
    When preencho os valores abaixo para simular
    | valor_aplicar  | valor_poupar | qtde_Dia_Ano  | mes_Ano |
    | 15.0				 	 | 5.0 				| 5						  | Ano			|
    Then o sistema deve me auxiliar com a mensagem "Valor minimo de 20.00"

    
 