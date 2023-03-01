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
	private double valorTotalVendas;
	private double valorCompra;
	private double valorImposto;
	private double precoVenda;
	private double precoCusto;
	static {
		parseID = 0;
	}
	// #endregion

	// #region CONSTRUTORES
	public Produto() {
		init("", 0, 10, 0, 0, 0, 0, 0, 0);
	}

	/**
	 * @param descricao nome/descricao
	 */
	public Produto(String descricao, double precoCusto, int quantidadeTotalAdquirida) {
		init(descricao, 0, quantidadeTotalAdquirida, 0, 0, 0, 0, 0, precoCusto);
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

	public double getValorCompra() {
		return valorCompra;
	}

	public int getQuantidadeVendidas() {
		return quantidadeTotalVendas;
	}

	public double getValorImposto() {
		return valorImposto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public double getValorTotalVendas() {
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

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public void setQuantidadeTotalVendas(int quantidadeTotalVendas) {
		this.quantidadeTotalVendas = quantidadeTotalVendas;
	}

	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public void setValorTotalVendas() {
		this.valorTotalVendas = CalculaValorArrecadado.calculaValorArrecadado(getPrecoVenda(), getQuantidadeVendidas());
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	// endregion
	
	private void init(String descricao, int quantidadeEstoque, int quantidadeTotalAdquirida, int quantidadeTotalVendas, double valorTotalVendas, double valorCompra, double valorImposto, double precoVenda, double precoCusto) {
		this.ID = ++parseID;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.quantidadeTotalComprada = 0;
		compra(quantidadeTotalAdquirida);
		this.quantidadeTotalVendas = quantidadeTotalVendas;
		this.valorTotalVendas = valorTotalVendas;
		this.valorCompra = valorCompra;
		this.valorImposto = valorImposto;
		this.precoVenda = precoVenda;
		this.precoCusto = precoCusto;
	}
	
	/**
	 * Realizar vendas
	 * 
	 * @param quantidadeProdutosVendidos quantidade vendida
	 */
	public void venda(int quantidadeProdutosVendidos) {
		Logger logger = Logger.getLogger(Produto.class.getName());
		if (quantidadeProdutosVendidos > 0) {
			if(this.quantidadeEstoque - quantidadeProdutosVendidos >= 10) {
				this.quantidadeEstoque -= quantidadeProdutosVendidos;
				this.quantidadeTotalVendas += quantidadeProdutosVendidos;
				valorTotalVendas += (quantidadeProdutosVendidos * this.precoVenda);
			} else {
				logger.log(Level.SEVERE, "Estoque insuficiente");
			}
		}else {
			logger.log(Level.SEVERE, "Quantidade de vendas incorreto");
		}
		
	}

	/**
	 * Calcula a quantidade total de produtos comprados pela mercearia
	 * 
	 * @param quantidadeProdutosComprados (quantidade total de produtos adquiridos)
	 */
	public void compra(int quantidadeProdutosComprados) {
		Logger logger = Logger.getLogger(Produto.class.getName());
		if(this.quantidadeEstoque + quantidadeProdutosComprados >= 10) {
			this.quantidadeEstoque += quantidadeProdutosComprados;
			this.quantidadeTotalComprada += quantidadeProdutosComprados;
		}else {
			logger.log(Level.SEVERE, "Estoque minimo insuficiente");
		}
	}

	private boolean verificaEstoque() {
		return quantidadeEstoque < 10 ? false : true;
	}

	/* Calcular Imposto */
	public double calcularImposto(double valorCompra, double margemLucro) { // após calcular o lucro, terminar aqui
		valorImposto = 0.18 * (valorCompra + margemLucro);
		return valorImposto;
	}

	/* Calcular preco de venda */
	public double calcularPrecoDeVenda(double valorCompra, double margemLucro) { // após calcular o lucro, terminar 																		// qui
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