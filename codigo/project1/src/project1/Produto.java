/**
 * 
 */
package project1;

/**
 * @author grupo8
 * @version 0.1
 *
 */
public class Produto {
	
	/********************
		Atributos
	********************/
	
	private static Integer parseID;
	
	private Integer ID;
	
	//descricao do produto, deve possuir apenas 3 caracteres, descricao.lenght >= 3 ?
	private String descricao;
	
	//registrar qtd em estoque, quantidade minima de cada produto � 10 itens.
	private int quantidadeEstoque;
	
	//registrar qtd total comprada, poderia ser qtdTotalVendas + qtdEstoque, mas pode ter perda de estoque futuramente.
	private int quantidadeTotalComprada;
	
	//registrar quantidade total do produto vendidas.
	private int quantidadeTotalVendas;
	
	//registrar valor bruto em dinheiro de vendas.
	private Double valorTotalVendas;

	//registrar valor bruto de compra
	private Double valorCompra;
	
	//registrar o valor do imposto
	private Double valorDoImposto;

	//registrar o valor do preco de venda
	private Double precoVenda;
	
	
	/********************
		Contrutores
	********************/
	
	public Produto() {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descricao = "";
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0.0;
		this.valorCompra = 0.0;
		this.valorDoImposto = 0.0;
		this.precoVenda = 0.0;
	}
	
	/**
	 * @param descricao nome/descricao
	 */
	public Produto(String descricao, Double valorCompra, int quantidadeVendida, Double valorDoImposto, Double precoVenda) {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descricao = descricao;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = quantidadeVendida;
		this.valorTotalVendas = 0.0;
		this.valorCompra = valorCompra;
		this.valorDoImposto = 0.0;
		this.precoVenda = 0.0;
	}
	
	/********************
		Metodos
	********************/
	
	/**GETS**/
	public Integer getID() {
		return this.ID;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidadeEstoque;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public int getQuantidadeVendidas() {
		return quantidadeTotalVendas;
	}
	
	/**SETS**/
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public void setQuantidadeTotalVendas(int quantidadeTotalVendas) {
		this.quantidadeTotalVendas = quantidadeTotalVendas;
	}


	/**
	 * Realizar vendas
	 * @param totalVendas quantidade vendida
	 */
	public void venda(int venda) {
		this.quantidadeTotalVendas += venda;
	}
	
	private boolean verificaEstoque() {
		return quantidadeEstoque<10? false:true;
	}

	
}
