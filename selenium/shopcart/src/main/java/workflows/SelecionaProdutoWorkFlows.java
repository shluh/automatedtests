package workflows;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import pageobjects.CheckoutPageObject;
import pageobjects.SelecionaProdutoPageObject;
import utils.TakeScreenshots;

public class SelecionaProdutoWorkFlows {
	private WebDriver driver;
	private SelecionaProdutoPageObject selecionaProduto;
	private CheckoutPageObject checkoutPage;
	

	public SelecionaProdutoWorkFlows(WebDriver driver) {
		this.driver = driver;
		this.selecionaProduto = new SelecionaProdutoPageObject(driver);
		this.checkoutPage = new CheckoutPageObject(driver);
		
	}
	
	/**
	  * Seleciona produtos para adicionar ao carrinho.
	  * 
	  * @param categoria   Informa a categoria escolhida para exibir itens respectivos
	  * @param todosItens    Informa se quer adicionar todos os itens (var = true) da categoria selecionada, ou item especifico (var = false) 
	  * @param nomeItem Se todosItens = false, então informar o nome do item especifico
	  * @throws Exception 
	  * 
	  */
	public void SelecionaProduto(String categoria, boolean todosItens, String nomeItem) throws Exception {
		selecionaProduto.SelecionaCategoriaBotao().click();
		for (WebElement elemento : selecionaProduto.SelecionaCategoria()) {
			if (elemento.getText().equals(categoria)) {
				elemento.click();
				break;
			}
		}
		TakeScreenshots.takeScreenshot(driver, "Categoria Selecionada") ;
		
		if (todosItens) {
			selecionaProduto.AdicionarTodosProdutoAoCarrinho();
		}
		if(!todosItens) {
			selecionaProduto.AdicionarProdutoEspecificoAoCarrinho(nomeItem);
		}
		TakeScreenshots.takeScreenshot(driver, "Item Selecionados") ;
		Reporter.log("Iniciando report... Produto Selecionado: Categoria ("+categoria+" ), Todos os itens ("+todosItens+" ), Nome do Item ("+nomeItem+"). FIM");
	}
	
	
	public void AcessaCarrinho() throws Exception {
		selecionaProduto.BotaorCarrinho().click();
		TakeScreenshots.takeScreenshot(driver, "Acessar Carrinho") ;
		Reporter.log("Iniciando report... Carrinho acessado. FIM");
	}
	
	public void CheckOutAdicionarUnidades(String item, int qtdeAdicionar) throws Exception {
		checkoutPage.AdicionarUnidades(item, qtdeAdicionar);
		TakeScreenshots.takeScreenshot(driver, "Checkout Unidades Adicionadas") ;
		Reporter.log("Iniciando report... Checkout adicionando unidades no item: "+item+" ; Quantidade ("+qtdeAdicionar+ " ) FIM");
	}
	
	public void CheckOutRemoverUnidades(String item, int qtdeRemover) throws Exception {
		checkoutPage.RemoverUnidades(item, qtdeRemover);
		TakeScreenshots.takeScreenshot(driver, "Checkout Unidades Removidas") ;
		Reporter.log("Iniciando report... Checkout removendo unidades no item: "+item+" ; Quantidade ("+qtdeRemover+ " ) FIM");
	}
	
	/**
	  * Validação de compra finalizada com sucesso.
	  * 
	  * É clicado no botão da interface 'Finalizar Compra'
	  * É feita validação da mensagem 'Compra Finalizada Com Sucesso'
	  * É fechado o painel de validação
	 * @throws Exception 
	  */
	public void FinalizarCompra() throws Exception {
		checkoutPage.FinalizarCompraBotao().click();
		assertTrue(checkoutPage.CompraFinalizadaComSucesso());
		TakeScreenshots.takeScreenshot(driver, "Compra finalizada com sucesso") ;
		checkoutPage.BotaoFechar().click();
		Reporter.log("Iniciando report... Compra finalizada com sucesso FIM");
	}

}
