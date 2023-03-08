/**
 * 
 */
package project1.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
	@BeforeAll
	void setUp() throws Exception {
		listaVazia = new ListaEncadeada();
		produtoVazio = new Produto();
	}

/*
	• Quantos produtos constam do estoque.
	• Qual o valor total do estoque atual.
	• Quais são os produtos atuais com estoque abaixo do mínimo.
	• Repor o estoque (comprar) ou retirar do estoque (produtos à escolha do administrador)
*/
	@Test
	void reporEstoque() {
		produtoVazio.alterarDescricao("teste");
		listaVazia.inserir(produtoVazio);
		assertEquals("teste", listaVazia.getProdutoPorID(0).getDescricao());
	}
	
	@Test
	void reporEstoqueMaisQuantidade() {
		for(int i = 0;i<10;i++) {
			produtoVazio.alterarDescricao("teste");
			listaVazia.inserir(produtoVazio);
		}
		Produto produtoTeste2 = new Produto();
		produtoTeste2.alterarDescricao("teste2");
		listaVazia.inserir(produtoTeste2);
		assertEquals("teste2", listaVazia.getProdutoPorID(10).getDescricao());
	}

}
