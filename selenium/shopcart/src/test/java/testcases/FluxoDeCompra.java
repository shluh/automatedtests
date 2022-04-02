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
		  selecionaProduto.SelecionaProduto("Todos",false,"Rissole m�dio");
		  selecionaProduto.AcessaCarrinho();
		  selecionaProduto.CheckOutAdicionarUnidades("Rissole m�dio", 9);
		  selecionaProduto.CheckOutRemoverUnidades("Rissole m�dio", 5);
		  selecionaProduto.FinalizarCompra();
		  
	  }

}
