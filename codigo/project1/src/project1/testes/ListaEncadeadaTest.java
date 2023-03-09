/**
 * 
 */
package project1.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


import project1.ListaEncadeada;
import project1.Produto;

/**
 * @author gabriel.tabatinga
 *
 */
class ListaEncadeadaTest {

	ListaEncadeada listaVazia;
	Produto produtoVazio;
	
	/**
	 * @throws java.lang.Exception
	 */
	
	
	@BeforeEach
	void setUp() throws Exception {
		listaVazia = new ListaEncadeada();
		produtoVazio = new Produto();
	}

/*
	� Quantos produtos constam do estoque.
	� Qual o valor total do estoque atual.
	� Quais sao os produtos atuais com estoque abaixo do minimo.
	� Repor o estoque (comprar) ou retirar do estoque (produtos e escolha do administrador)
*/

	//Valida se o produto um foi inserido no estoque
	//4
	@Test
	void deveInserirUmProdutoNoEstoqueREPOSICAO() throws Exception {
		produtoVazio.alterarDescricao("teste");
		listaVazia.inserir(produtoVazio);
		assertEquals(produtoVazio.getDescricao(), listaVazia.getProdutoPorID(produtoVazio.getID()).getDescricao());
	}
	
	//Confere se varios produtos foram inseridos no estoque
	//4
	@Test
	void deveInserirVariosProdutosNoEstoqueREPOSICAO() throws Exception {
		for(int i = 0;i<10;i++) {
			Produto produto = new Produto();
			produto.alterarDescricao("teste" + i);
			listaVazia.inserir(produto);
		}
		Produto produtoTeste2 = new Produto();
		produtoTeste2.alterarDescricao("testeZ");
		listaVazia.inserir(produtoTeste2);
		assertEquals("testeZ", listaVazia.getProdutoPorID(produtoTeste2.getID()).getDescricao());
	}
	
	//testa o metodo "qtdProdutoEstoque" inserindo 1 produto
	//quantos produtos constam no estoque
	@Test
	void deveMostrarNoEstoqueUmProduto() {
		listaVazia.inserir(produtoVazio);
		assertEquals(1, listaVazia.quantidadeProdutosEstoque());
	}
	
	//testa o metodo "qtdProdutoEstoque" inserindo 0 produto
	@Test
	void deveMostrarNoEstoqueZeroProduto() {
		assertEquals(0, listaVazia.quantidadeProdutosEstoque());
	}
	
	//testa o metodo "qtdProdutoEstoque" inserindo varios produto
	@Test
	void DeveMostrarNoEstoqueSeisProdutos() {
		listaVazia.inserir(produtoVazio);
		listaVazia.inserir(produtoVazio);
		listaVazia.inserir(produtoVazio);
		listaVazia.inserir(produtoVazio);
		listaVazia.inserir(produtoVazio);
		listaVazia.inserir(produtoVazio);
		assertEquals(6, listaVazia.quantidadeProdutosEstoque());
	}
	
	//confere se a lista nao esta vazia 
	@Test
	void confereListaVazia() {
		ListaEncadeada lista = new ListaEncadeada();
		Exception exception = assertThrows(Exception.class, () -> {
			lista.getProdutoPorID(999999999);
	    });
		String expectedMessage = "Nao foi possivel encontrar o item na lista: a lista esta vazia!";

		assertEquals(expectedMessage, exception.getMessage());
		
	}
	
	//confere se foi removido 0 produto
	@Test 
	void deveRemoverUmProdutoNoEstoque() {
		listaVazia.inserir(produtoVazio);
		listaVazia.remover(produtoVazio);
		assertEquals(0, listaVazia.quantidadeProdutosEstoque());
	}
	
	//Confere se foi removido varios produtos da Lista
	@Test 
	void deveValidarQtdDeProdutosAposRealizarCompra() {
		Produto produtoTeste2 = new Produto();
		listaVazia.inserir(produtoVazio);
		listaVazia.inserir(produtoTeste2);
		listaVazia.inserir(produtoTeste2);
		listaVazia.inserir(produtoTeste2);
		listaVazia.inserir(produtoTeste2);
		listaVazia.remover(produtoVazio);
		assertEquals(4, listaVazia.quantidadeProdutosEstoque());
	}
	
	//verifica o estoque com qtd abaixa do minimo
	@Test
	void deveMostrarQuantidadeEstoqueMinimo() {
		produtoVazio.efetuarCompra(9);
		produtoVazio.alterarDescricao("as");
		listaVazia.inserir(produtoVazio);
		assertEquals("as", listaVazia.produtosAbaixoMinimoEstoque());
		
	}
	
	//verifica o estoque com qtd acima do minimo; ou seja nao vai gerar alerta
	@Test
	void devequantidadeEstoqueMinimoAcimaDez() {
		produtoVazio.efetuarCompra(10);
		produtoVazio.alterarDescricao("asa");
		listaVazia.inserir(produtoVazio);
		assertEquals("", listaVazia.produtosAbaixoMinimoEstoque());
		
	}
	
	// verifica o alerta do estoque minimo e a saida (se a descricao ta certa) 
	@Test
	void quantidadeVariosEstoqueMinimo() {
		produtoVazio.alterarDescricao("asa");
		Produto produtoTeste2 = new Produto();
		produtoTeste2.alterarDescricao("bsa");
		Produto produtoTeste3 = new Produto();
		produtoTeste3.alterarDescricao("csa");
		Produto produtoTeste4 = new Produto();
		produtoTeste4.alterarDescricao("dsa");
		
		produtoVazio.efetuarCompra(8);
		produtoTeste2.efetuarCompra(4);
		produtoTeste3.efetuarCompra(10);
		produtoTeste4.efetuarCompra(9);
		
		listaVazia.inserir(produtoVazio);
		listaVazia.inserir(produtoTeste2);
		listaVazia.inserir(produtoTeste3);
		listaVazia.inserir(produtoTeste4);
		
		
		assertEquals("asa bsa dsa", listaVazia.produtosAbaixoMinimoEstoque());
	}
	
	//Verifica o valor total em $$ dos produtos no estoque
	@Test
	void valorTotalEmEstoque() {
		produtoVazio.alterarPrecoCusto(3);
		produtoVazio.efetuarCompra(10);
		listaVazia.inserir(produtoVazio);
		
		Produto produtoTeste2 = new Produto();
		produtoTeste2.alterarPrecoCusto(3);
		produtoTeste2.efetuarCompra(15);
		listaVazia.inserir(produtoTeste2);
		
		assertEquals(75, listaVazia.valorTotalEstoque());
	}
	
	

}
