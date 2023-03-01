/**
 * 
 */
package project1;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @author grupo8
 * @version 0.1
 *
 */
public class Produto {	
	//#region ATRIBUTOS
	private static Integer parseID;

	private Integer ID;
	
	private String descricao; //Deve possuir um mínimo de 3 caracteres
	
	private int quantidadeEstoque; //Quantidade mínima de cada produto = 10 itens
	
	private int quantidadeTotalComprada;
	
	private int quantidadeTotalVendas;
	
	private Double valorTotalVendas;

	private Double valorCompra;
	
	private Double valorImposto;

	private Double precoVenda;

	private Double precoCusto;
	//#endregion

	//#region CONSTRUTORES	
	public Produto() {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descricao = "";
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0.0;
		this.valorCompra = 0.0;
		this.valorImposto = 0.0;
		this.precoVenda = 0.0;
		this.precoCusto = 0.0;
	}
	
	/**
	 * @param descricao nome/descricao
	 */
	public Produto(String descricao, Double valorCompra, int quantidadeVendida, Double valorImposto, Double precoVenda, Double precoCusto) {
		if(parseID == null) {parseID = 0;}
		this.ID = ++parseID;
		this.descricao = descricao;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = quantidadeVendida;
		this.valorTotalVendas = 0.0;
		this.valorCompra = valorCompra;
		this.valorImposto = 0.0;
		this.precoVenda = 0.0;
		this.precoCusto = precoCusto;
	}
	//#endregion
	
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
	
	public Double getValorImposto(){
		return valorImposto;
	}

	public Double getPrecoVenda(){
		return precoVenda;
	}

	public Double getValorTotalVendas(){
		return valorTotalVendas;
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

	public void setValorImposto(){
		this.valorImposto = valorImposto;
	}

	public void setPrecoVenda(Double precoVenda){
		this.precoVenda = precoVenda;
	}

	public void setValorTotalVendas(){
		this.valorTotalVendas = CalculaValorArrecadado.calculaValorArrecadado(getPrecoVenda(), getQuantidadeVendidas());
	}

	public void setQuantidadeEstoque(int quantidadeEstoque){
		this.quantidadeEstoque = quantidadeEstoque;
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

	/*Calcular Imposto*/
	public Double calcularImposto(Double valorCompra ){ //após calcular o lucro, terminar aqui
		valorImposto = 0.18*(valorCompra);
		return valorImposto;
	}

	/*Calcular preco de venda*/
	public Double calcularPrecoDeVenda(Double valorCompra, Double valorImposto){ //após calcular o lucro, terminar aqui
		precoVenda = valorCompra + calcularImposto(valorCompra);
		return precoVenda;
	}

	public void adicionaEstoque(int quantidadeProdutoComprada){
		int quantidadeAtualEmEstoque = getQuantidade();
		setQuantidadeEstoque(quantidadeAtualEmEstoque + quantidadeProdutoComprada);
	}

	public void removeEstoque(int quantidadeProdutoVendida){
		Logger logger = Logger.getLogger(Produto.class.getName());

		int quantidadeAtualEmEstoque = getQuantidade();

		if(quantidadeAtualEmEstoque >= quantidadeProdutoVendida){
			setQuantidadeEstoque(quantidadeAtualEmEstoque - quantidadeProdutoVendida);
		}
		else{
			logger.log(Level.SEVERE, "A quantidade atual em estoque é inferior a quantidade desejada");
		}
	}
}
