package project1;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @author grupo8
 * @version 0.1
 *
 */
public class Produto {
	// #region ATRIBUTOS
	private static int parseID;
	private int ID;
	protected String descricao; // Deve possuir um mínimo de 3 caracteres
	private int quantidadeEstoque; // Quantidade mínima de cada produto = 10 itens
	private int quantidadeTotalComprada;
	private int quantidadeTotalVendas;
	private Double valorTotalVendas;
	private Double valorCompra;
	private Double valorImposto;
	private Double precoVenda;
	private Double precoCusto;
	static {
		parseID = 0;
	}
	// #endregion

	// #region CONSTRUTORES
	public Produto() {
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
	public Produto(String descricao, Double precoCusto, int quantidadeTotalAdquirida) {
		this.ID = ++parseID;
		this.descricao = descricao;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = quantidadeComprada(quantidadeTotalAdquirida);
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0.0;
		this.valorCompra = 0.0;
		this.valorImposto = 0.0;
		this.precoVenda = 0.0;
		this.precoCusto = precoCusto;
	}
	// #endregion

	/********************
	 * Metodos
	 ********************/

	// #region GETS
	public int getID() {
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

	public Double getValorImposto() {
		return valorImposto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public Double getValorTotalVendas() {
		return valorTotalVendas;
	}
	// #endregion

	// #region SETS
	public void setDescricao(String descricao) {
		Logger logger = Logger.getLogger(Produto.class.getName());
		if (descricao.length() < 3) {
			logger.log(Level.SEVERE, "A descrição deve possuir no mínimo 3 caracteres");
		}
		this.descricao = descricao;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public void setQuantidadeTotalVendas(int quantidadeTotalVendas) {
		this.quantidadeTotalVendas = quantidadeTotalVendas;
	}

	public void setValorImposto(Double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public void setValorTotalVendas() {
		this.valorTotalVendas = CalculaValorArrecadado.calculaValorArrecadado(getPrecoVenda(), getQuantidadeVendidas());
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	// endregion

	/**
	 * Realizar vendas
	 * 
	 * @param quantidadeProdutosVendidos quantidade vendida
	 */
	public void quantidadeVendida(int quantidadeProdutosVendidos) {
		this.quantidadeTotalVendas += quantidadeProdutosVendidos;
	}

	/**
	 * Calcula a quantidade total de produtos comprados pela mercearia
	 * 
	 * @param quantidadeProdutosComprados (quantidade total de produtos adquiridos)
	 */
	public int quantidadeComprada(int quantidadeProdutosComprados) {
		return quantidadeTotalComprada += quantidadeProdutosComprados;
	}

	private boolean verificaEstoque() {
		return quantidadeEstoque < 10 ? false : true;
	}

	/* Calcular Imposto */
	public Double calcularImposto(Double valorCompra, Double margemLucro) { // após calcular o lucro, terminar aqui
		valorImposto = 0.18 * (valorCompra + margemLucro);
		return valorImposto;
	}

	/* Calcular preco de venda */
	public Double calcularPrecoDeVenda(Double valorCompra, Double margemLucro) { // após calcular o lucro, terminar 																		// qui
		precoVenda = valorCompra + calcularImposto(valorCompra, margemLucro) + margemLucro;
		return precoVenda;
	}

	/**
	 * Adicionar itens no estoque após compra de novos produtos
	 * 
	 * @param quantidadeProdutosComprados
	 */
	public void adicionaEstoque(int quantidadeProdutosComprados) {
		int quantidadeAtualEmEstoque = getQuantidade();
		setQuantidadeEstoque(quantidadeAtualEmEstoque + quantidadeProdutosComprados);
	}

	/**
	 * Remove itens do estoque após realizar venda de produtos
	 * 
	 * @param quantidadeProdutosVendidos
	 */
	public void removeEstoque(int quantidadeProdutosVendidos) {
		Logger logger = Logger.getLogger(Produto.class.getName());

		int quantidadeAtualEmEstoque = getQuantidade();

		if (quantidadeAtualEmEstoque < quantidadeProdutosVendidos) {
			logger.log(Level.SEVERE, "A quantidade atual em estoque é inferior a quantidade desejada");

			setQuantidadeEstoque(quantidadeAtualEmEstoque - quantidadeProdutosVendidos);
		}
	}
}