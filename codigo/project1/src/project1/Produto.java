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
	
	//descrição do produto, deve possuir apenas 3 caracteres, descrição.lenght >= 3 ?
	private String descrição;
	
	//registrar qtd em estoque, quantidade mínima de cada produto é 10 itens.
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
		this.descrição = "";
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0.0;
	}
	
	/**
	 * @param descrição nome/descrição
	 */
	public Produto(String descrição) {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descrição = descrição;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0.0;
	}
	
	/********************
		Métodos
	********************/
	
	/**
	 * @return ID do produto (gerado automaticamente)
	 */
	public Integer getID() {
		return this.ID;
	}
	
	/**
	 * Retorna descrição
	 * @return descrição descrição
	 */
	public String getDescrição() {
		return descrição;
	}


	/**
	 * Altera descrição
	 * @param descrição nova descrição
	 */
	public void setDescrição(String descrição) {
		this.descrição = descrição;
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
