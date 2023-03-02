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
	private double valorTotalCompra;
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
		init("", 0, 0, 0);
	}

	/**
	 * @param descricao nome/descricao
	 */
	public Produto(String descricao, int quantidadeTotalAdquirida, double precoCusto, double margemLucro) {
		init(descricao, quantidadeTotalAdquirida, precoCusto, margemLucro);
	}
	// #endregion

	/********************
	 * Metodos
	 ********************/

	// #region GETS
	public int getID() {
		return this.ID;
	}
	public int getQuantidadeVendidas() {
		return quantidadeTotalVendas;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	// #endregion

	// #region SETS
	public void alterarDescricao(String descricao) {
		Logger logger = Logger.getLogger(Produto.class.getName());
		if (descricao.length() < 3) {
			logger.log(Level.SEVERE, "A descrição deve possuir no mínimo 3 caracteres");
		}
		this.descricao = descricao;
	}

	public void setCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	// endregion
	
	private void init(String descricao, int quantidadeTotalAdquirida, double precoCusto, double margemLucro) {
		this.ID = ++parseID;
		if(descricao != "")
			alterarDescricao(descricao);
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0;
		this.valorTotalCompra = 0;
		this.precoCusto = precoCusto;
		this.margemLucro = calcularMargemLucro(margemLucro);
		this.precoVenda = calcularPrecoDeVendaUnitario(precoCusto);
		if(quantidadeTotalAdquirida >=10)
			efetuarCompra(quantidadeTotalAdquirida);
	}
	
	public void calcularValorArrecadado(){
        this.valorTotalVendas = precoCusto * quantidadeTotalVendas;
    }

	/**
	 * Realizar vendas
	 * 
	 * @param quantidadeProdutosVendidos quantidade vendida
	 */
	public void efetuarVenda(int quantidadeProdutosVendidos) {
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
	public void efetuarCompra(int quantidadeProdutosComprados) {
		Logger logger = Logger.getLogger(Produto.class.getName());
		if(this.quantidadeEstoque + quantidadeProdutosComprados >= 10) {
			adicionarEstoque(quantidadeProdutosComprados);
			this.valorTotalCompra = calcularValorAquisicao(quantidadeProdutosComprados);
		}else {
			logger.log(Level.SEVERE, "Estoque minimo insuficiente");
		}
	}

		
	private double calcularValorAquisicao(int quantidade) { 
		return this.precoCusto * quantidade;
	}

	
	/**
	 * Calcular margem de lucro
	 * 
	 * @param porcentagem deve ser informado como exemplo calcularMargemLucro(30), para 30%
	 */
	private double calcularMargemLucro(double porcentagem) { 
		Logger logger = Logger.getLogger(Produto.class.getName());
		porcentagem /= 100;
		if(porcentagem >= 0.3 && porcentagem <= 0.8) {
			return this.precoCusto * porcentagem;
		}else {
			//logger.log(Level.WARNING, "Porcentagem da margem de lucro incorreta, setando como 30%");
			return this.precoCusto * 0.3;
		}
	}


	/**
	 * Calcular imposto sobre o produto
	 * 
	 * @return imposto sobre valor do produto
	 */
	private double calcularImposto() { 
		return valorImposto * (precoCusto + margemLucro);
	}

	/**
	 * Calcular preço de venda de um produto 
	 * 
	 * @return preço de venda do produto
	 */
	private double calcularPrecoDeVendaUnitario(double custo) { 											
		return custo + calcularImposto() + margemLucro;
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