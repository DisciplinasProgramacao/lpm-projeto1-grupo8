package project1;

/**
 * @author 
 * Arthur Jansen Oliveira
 * Bárbara Mattioly Andrade
 * Gabriel Pimentel Tabatinga
 * Henrique Grissi C Soeiro de Carvalho
 * Laura Enísia Rodrigues Melo
 * 
 * 
 * @version 0.1
 *
 */
public class Mercearia {
	
	// #region ATRIBUTOS
	private ListaEncadeada listaProdutos;
	// #endregion


	// #region CONSTRUTORES
	Mercearia(){
		 this.listaProdutos = new ListaEncadeada();
	}
	// #endregion


	// #region METODOS

	/**
	 * @param descricao do produto a ser adicionado
	 */
	public void adicionarProduto(String descricao, double precoCusto, double margemLucro, int quantidadeTotalAdquirida) {
		Produto produto = new Produto(descricao, quantidadeTotalAdquirida, precoCusto, margemLucro);
		this.listaProdutos.inserir(produto);
	}
	
	/**
	 * Adiciona um produto no estoque 
	 * 
	 * @param produto
	 */
	public void adicionarProduto(Produto produto) {
		this.listaProdutos.inserir(produto);
	}
	/**
	 * Mostra a quantidade de produtos cadastrados no estoque 
	 * 
	 * @return
	 */
	public int receberQtdProdutosCadastradosEstoque() {
		return this.listaProdutos.quantidadeProdutosEstoque();
	}
	
	/**
	 * Remove um produto do estoque 
	 * 
	 * @param produto
	 */
	public void removerProduto(Produto produto) {
		this.listaProdutos.remover(produto);
	}
	
	/**
	 * Remove um produto do estoque a partir da descricao 
	 * 
	 * @param produto
	 */
	public void removerProduto(String descr) throws Exception {
		this.listaProdutos.remover(listaProdutos.getProdutoPorDescricao(descr));
	}
	
	/**
	 * Lista os produtos que estao abaixo do estoque minimo
	 * @return listaProdutosAbaixoMinimoEstoque
	 */
	public String receberNomesProdutosAbaixoMinimoEstoque() {
		return this.listaProdutos.produtosAbaixoMinimoEstoque();
	}
	
	/**
	 * Mostra o valor total dos atuais produtos em estoque
	 * @return valor
	 */
	public double receberValorTotalEmEstoque() {
		return this.listaProdutos.valorTotalEstoque();
	}

	/**
	 * Mostra o produto a partir do seu ID
	 * 
	 * @param ID
	 * @return
	 * @throws Exception
	 */
	public Produto receberProdutoPorID (int ID) throws Exception {
		return this.listaProdutos.getProdutoPorID(ID);
	}
	
	/**
	 * Mostra o produto a partir da sua descricao
	 * @param descricao
	 * @return
	 * @throws Exception
	 */
	public Produto receberProdutoPorDescricao (String descricao) throws Exception {
		return this.listaProdutos.getProdutoPorDescricao(descricao);
	}
	
	/**
	 * Realiza a venda de produtos da mercearia
	 * @param desc
	 * @param qtd
	 * @throws Exception
	 */
	public void vender (String desc, int qtd) throws Exception {
		this.listaProdutos.getProdutoPorDescricao(desc).efetuarVenda(qtd);
	}
	
	/**
	 * Efetua a compra de produtos para repor o estoque da mercearia
	 * @param desc
	 * @param qtd
	 */
	public void comprar(String desc, int qtd) {
		try {
			this.listaProdutos.getProdutoPorDescricao(desc).efetuarCompra(qtd);
		} catch (Exception e) {
			Produto produto = new Produto();
			produto.alterarDescricao(desc);
			produto.efetuarCompra(qtd);
			this.listaProdutos.inserir(produto);
		}
	}
	
	/**
	 * Mostra os produtos existentes na mercearia
	 * @return
	 */
	public String listarProdutos() {
		return this.listaProdutos.listarProdutos();
	}
	
	/**
	 * Mostra o valor total dos produtos vendidos na mercearia
	 * @return valor total dos produtos vendidos
	 */
	public double receberValorTotalVendido() {
		return this.listaProdutos.valorTotalVendido();
	}
	
	/**
	 * Mostra o valor total gasto na compra de produtos reabastecidos no estoque
	 * @return
	 */
	public double receberValorTotalReposicao() {
		return this.listaProdutos.valorTotalReposicao();
	}
	
	/**
	 * Mostra a descricao com os dados de um produto informado
	 * @param descricao
	 * @return
	 * @throws Exception
	 */
	public String receberInfosProduto (String descricao) throws Exception {
		return this.listaProdutos.getProdutoPorDescricao(descricao).listarInformacoesProduto();
	}
	// #endregion
}
