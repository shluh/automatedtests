package testcases;

import org.testng.annotations.Test;

import utils.ClasseBase;

public class FluxoDeCompra extends ClasseBase{
	
	@Test(priority=1)
	  public void DesafioUm() throws Exception {
		  selecionaProduto.SelecionaProduto("Doces",true,"");
		  selecionaProduto.AcessaCarrinho();
		  selecionaProduto.CheckOutAdicionarUnidades("Brigadeiro", 4);
		  selecionaProduto.FinalizarCompra();
	  }
	
	@Test(priority=2)
	  public void DesafioDois() throws Exception{

		  selecionaProduto.SelecionaProduto("Bebidas",true,"");
		  selecionaProduto.SelecionaProduto("Todos",false,"Rissole médio");
		  selecionaProduto.AcessaCarrinho();
		  selecionaProduto.CheckOutAdicionarUnidades("Rissole médio", 9);
		  selecionaProduto.CheckOutRemoverUnidades("Rissole médio", 5);
		  selecionaProduto.FinalizarCompra();
		  
	  }

}
