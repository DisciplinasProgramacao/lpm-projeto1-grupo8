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
	
	public void adicionarProduto(Produto produto) {
		this.listaProdutos.inserir(produto);
	}
	
	public int receberQtdProdutosCadastradosEstoque() {
		return this.listaProdutos.quantidadeProdutosEstoque();
	}
	
	public void removerProduto(Produto produto) {
		this.listaProdutos.remover(produto);
	}
	
	public void removerProduto(String descr) throws Exception {
		this.listaProdutos.remover(listaProdutos.getProdutoPorDescricao(descr));
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
	
	public void vender (String desc, int qtd) throws Exception {
		this.listaProdutos.getProdutoPorDescricao(desc).efetuarVenda(qtd);
	}
	
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
	
	public String listarProdutos() {
		return this.listaProdutos.listarProdutos();
	}
	
	public double receberValorTotalVendido() {
		return this.listaProdutos.valorTotalVendido();
	}
	
	public double receberValorTotalReposicao() {
		return this.listaProdutos.valorTotalReposicao();
	}
	
}
