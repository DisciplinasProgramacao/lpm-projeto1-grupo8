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
	private String descri��o;
	
	//registrar qtd em estoque, quantidade m�nima de cada produto � 10 itens.
	private int quantidadeEstoque;
	
	//registrar qtd total comprada, poderia ser qtdTotalVendas + qtdEstoque, mas pode ter perda de estoque futuramente.
	private int quantidadeTotalComprada;
	
	//registrar quantidade total do produto vendidas.
	private int quantidadeTotalVendas;
	
	//registrar valor bruto em dinheiro de vendas.
	private Double valorTotalVendas;

	
	
	/********************
		Contrutores
	********************/
	
	public Produto() {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descri��o = "";
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0.0;
	}
	
	/**
	 * @param descri��o nome/descri��o
	 */
	public Produto(String descri��o) {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descri��o = descri��o;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0.0;
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
	public String getDescri��o() {
		return descri��o;
	}


	/**
	 * Altera descri��o
	 * @param descri��o nova descri��o
	 */
	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
	}

	/**
	 * Retorna quantidade
	 * @return quantidade quatidade
	 */
	public int getQuantidade() {
		return quantidadeEstoque;
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
