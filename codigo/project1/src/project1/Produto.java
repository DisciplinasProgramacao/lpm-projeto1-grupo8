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
	
	//descri��o do produto, deve possuir apenas 3 caracteres, descri��o.lenght >= 3 ?
	private String descricao;
	
	//registrar qtd em estoque, quantidade m�nima de cada produto � 10 itens.
	private int quantidadeEstoque;
	
	//registrar qtd total comprada, poderia ser qtdTotalVendas + qtdEstoque, mas pode ter perda de estoque futuramente.
	private int quantidadeTotalComprada;
	
	//registrar quantidade total do produto vendidas.
	private int quantidadeTotalVendas;
	
	//registrar valor bruto em dinheiro de vendas.
	private Double valorTotalVendas;

	//registrar valor bruto de compra
	private Double valorCompra;

	
	
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
	}
	
	/**
	 * @param descri��o nome/descri��o
	 */
	public Produto(String descricao, Double valorCompra, int quantidadeVendida) {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descricao = descricao;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = quantidadeVendida;
		this.valorTotalVendas = 0.0;
		this.valorCompra = valorCompra;
	}
	
	/********************
		M�todos
	********************/
	
	/**
	 * @return ID do produto (gerado automaticamente)
	 */
	public Integer getID() {
		return this.ID;
	}
	
	/**
	 * Retorna descri��o
	 * @return descri��o descri��o
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * Altera descri��o
	 * @param descricao nova descri��o
	 */
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
	 * Retorna quantidade
	 * @return quantidade quatidade
	 */
	public int getQuantidade() {
		return quantidadeEstoque;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public int getQuantidadeVendidas() {
		return quantidadeTotalVendas;
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
