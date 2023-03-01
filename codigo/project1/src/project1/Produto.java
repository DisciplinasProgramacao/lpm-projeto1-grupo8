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
	private static double valorImposto;
	private double margemLucro;
	private double precoVenda;
	private double precoCusto;
	static {
		parseID = 0;
		valorImposto = 0.18;
	}
	// #endregion

	// #region CONSTRUTORES
	public Produto() {
		init("", 10, 0, 0, 0, 0, 0);
	}

	/**
	 * @param descricao nome/descricao
	 */
	public Produto(String descricao, double precoCusto, double margemLucro, int quantidadeTotalAdquirida) {
		init(descricao, quantidadeTotalAdquirida, 0, 0, 0, margemLucro, precoCusto);
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
	
	public int getQuantidadeComprada() {
		return quantidadeTotalComprada;
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

	public void setCusto(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	//alterar
	public void setValorTotalVendas() {
		this.valorTotalVendas = CalculaValorArrecadado.calculaValorArrecadado(getPrecoVenda(), getQuantidadeVendidas());
	}

	// endregion
	
	private void init(String descricao, int quantidadeTotalAdquirida, int quantidadeTotalVendas, double valorTotalVendas, double valorCompra, double margemLucro, double precoCusto) {
		this.ID = ++parseID;
		this.descricao = descricao;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		compra(quantidadeTotalAdquirida);
		this.quantidadeTotalVendas = quantidadeTotalVendas;
		this.valorTotalVendas = valorTotalVendas;
		this.valorCompra = valorCompra;
		calcularMargemLucro(margemLucro);
		calcularPrecoDeVenda();
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
			if(this.quantidadeEstoque - quantidadeProdutosVendidos < 0) {
				logger.log(Level.SEVERE, "Estoque insuficiente");
			}else {
				if(this.quantidadeEstoque - quantidadeProdutosVendidos < 10) {
					logger.log(Level.SEVERE, "Estoque abaixo do minimo");
				}
				removerEstoque(quantidadeProdutosVendidos);
				this.quantidadeTotalVendas += quantidadeProdutosVendidos;
				valorTotalVendas += (quantidadeProdutosVendidos * this.precoVenda);
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
			adicionarEstoque(quantidadeProdutosComprados);
		}else {
			logger.log(Level.SEVERE, "Estoque minimo insuficiente");
		}
	}

	/**
	 * Calcular valor do imposto sobre o produto
	 * 
	 * @return imposto sobre valor do produto
	 */
	private double calcularImposto() { // após calcular o lucro, terminar aqui
		return valorImposto * (valorCompra + margemLucro);
	}

	private double calcularPrecoDeVenda() { 																		// qui
		return valorCompra + calcularImposto() + margemLucro;
	}
	
	/**
	 * Calcular margem de lucro
	 * 
	 * @param porcentagem deve ser informado como exemplo calcularMargemLucro(30), para 30%
	 */
	private void calcularMargemLucro(double porcentagem) { 
		Logger logger = Logger.getLogger(Produto.class.getName());
		porcentagem /= 100;
		if(porcentagem >= 0.3 && porcentagem <= 0.8) {
			this.margemLucro = this.precoCusto * porcentagem;
		}else {
			this.margemLucro = this.precoCusto * 0.3;
			logger.log(Level.SEVERE, "Porcentagem da margem de lucro incorreta");
		}
		
	}

	/**
	 * Adicionar itens no estoque após compra de novos produtos
	 * 
	 * @param quantidadeProdutosComprados
	 */
	private void adicionarEstoque(int quantidadeProdutosComprados) {
		this.quantidadeEstoque += quantidadeProdutosComprados;
		this.quantidadeTotalComprada += quantidadeProdutosComprados;
	}

	/**
	 * Remove itens do estoque após realizar venda de produtos
	 * 
	 * @param quantidadeProdutosVendidos
	 */
	private void removerEstoque(int quantidadeProdutosVendidos) {
		this.quantidadeEstoque -= quantidadeProdutosVendidos;
	}
}