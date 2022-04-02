$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/SimuladorDeInvestimento.feature");
formatter.feature({
  "line": 2,
  "name": "Simular Investimento",
  "description": "Com o proposito de Simular um Investimento na Poupanca\r\ncomo um Associado,\r\neu gostaria de preencher o formulario de simulacao\r\ne ver a tabela de resultado com mes e Valor.",
  "id": "simular-investimento",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@SimulacaoInvestimentoPoupanca"
    }
  ]
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "Eu sou um associado",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "gostaria de fazer uma simulacao de poupança",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "ver a tabela de resultado com mes e Valor.",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 15,
  "name": "Simulacao Poupanca",
  "description": "",
  "id": "simular-investimento;simulacao-poupanca",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@SimulacaoPoupanca"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "A pagina de simulacao carregada",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "eu sou um associado",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "preencho os valores abaixo para simular",
  "rows": [
    {
      "cells": [
        "valor_aplicar",
        "valor_poupar",
        "qtde_Dia_Ano",
        "mes_Ano"
      ],
      "line": 19
    },
    {
      "cells": [
        "1500.0",
        "500.0",
        "5",
        "Ano"
      ],
      "line": 20
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "clico no botao para simular",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "eu vejo a tabela de resultado com mes valor de opcoes para simular",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "StepDefinitions.eu_sou_um_associado()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.preencho_os_valores_abaixo_para_simular()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.clico_no_botao_para_simular(int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.eu_vejo_a_tabela_de_resultado_com_mes_valor_de_opcoes_para_simular()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Valores Minimos Simulacao",
  "description": "",
  "id": "simular-investimento;valores-minimos-simulacao",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 25,
      "name": "@ValoresMinimosSimulacao"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "A pagina de simulacao carregada",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "eu sou um associado",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "preencho os valores abaixo para simular",
  "rows": [
    {
      "cells": [
        "valor_aplicar",
        "valor_poupar",
        "qtde_Dia_Ano",
        "mes_Ano"
      ],
      "line": 30
    },
    {
      "cells": [
        "15.0",
        "5.0",
        "5",
        "Ano"
      ],
      "line": 31
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "o sistema deve me auxiliar com a mensagem \"Valor minimo de 20.00\"",
  "keyword": "Then "
});
});