/**
 * 
 */
package project1;

/**
 * @author grupo8
 * @version 0.1
 *
 */
public class Mercearia {
	
	/********************
		Atributos
	********************/
	private String nome;
	
	private ListaEncadeada listaProdutos;
	
	/********************
		Contrutores
	********************/
	
	Mercearia(){
		 this.listaProdutos = new ListaEncadeada();
	}
	

	/**
	 * @param descricao do produto a ser adicionado
	 */
	public void adicionarProduto(String descricao, double precoCusto, double margemLucro, int quantidadeTotalAdquirida) {
		Produto produto = new Produto(descricao, quantidadeTotalAdquirida, precoCusto, margemLucro);
		this.listaProdutos.inserir(produto);
	}
	
	public int receberQtdProdutosCadastradosEstoque() {
		return this.listaProdutos.quantidadeProdutosEstoque();
	}
	
	public void removerProduto(Produto produto) {
		this.listaProdutos.remover(produto);
	}
	
	public String receberNomesProdutosAbaixoMinimoEstoque() {
		return this.listaProdutos.produtosAbaixoMinimoEstoque();
	}
	
	public double receberValorTotalEmEstoque() {
		return this.listaProdutos.valorTotalEstoque();
	}

	public Produto receberProdutoPorID (int ID) throws Exception {
		return this.listaProdutos.getProdutoPorID(ID);
	}
	
	public Produto receberProdutoPorDescricao (String descricao) throws Exception {
		return this.listaProdutos.getProdutoPorDescricao(descricao);
	}
	
}
