package project1;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @author grupo8
 * @version 0.1
 *
 */
public class Produto {
    private final Logger logger = Logger.getLogger(Produto.class.getName());
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
	private double precoVenda;
	private double precoCusto;
	static {
		parseID = 0;
		valorImposto = 0.18;
	}
	// #endregion

	// #region GETS
	public int getID() {
		return this.ID;
	}

	public int getQuantidadeVendidas() {
		return quantidadeTotalVendas;
	}
	
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public double getValorTotalEstoque() {
		return precoCusto * quantidadeEstoque;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}
	
	public String getDescricao() {
		return descricao;
	}

	// #endregion

	// #region CONSTRUTORES
	private void init(String descricao, int quantidadeTotalAdquirida, double precoCusto, double margemLucro) {
		this.ID = parseID++;
		alterarDescricao(descricao);
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0;
		this.valorTotalCompra = 0;
		this.precoCusto = precoCusto;
		if (margemLucro > 0)
			this.precoVenda = calcularPrecoDeVendaUnitario(margemLucro);
		if (quantidadeTotalAdquirida >= 10)
			efetuarCompra(quantidadeTotalAdquirida);
	}

	public Produto() {
		init(null, 0, 0, 0);
	}

	/**
	 * @param descricao nome/descricao
	 */
	public Produto(String descricao, int quantidadeTotalAdquirida, double precoCusto, double margemLucro) {
		init(descricao, quantidadeTotalAdquirida, precoCusto, margemLucro);
	}
	// #endregion

	// #region Métodos
	public void alterarDescricao(String descricao) {
		if (descricao != null) {
			if(descricao.length() < 3) {
				System.out.print("A descrição é obrigatória e deve possuir no mínimo 3 caracteres");
				//logger.log(Level.SEVERE, "A descrição é obrigatória e deve possuir no mínimo 3 caracteres");
			}
		}
		this.descricao = descricao;
	}
	
	
	public void alterarPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	/**
	 * Calcular preço de venda de um produto
	 * 
	 * @return preço de venda do produto
	 */
	private double calcularPrecoDeVendaUnitario(double porcentagemMargemLucro) {
		double margemLucroCalculada = calcularMargemLucro(porcentagemMargemLucro);
		return this.precoCusto + calcularImposto(margemLucroCalculada) + margemLucroCalculada;
	}

	/**
	 * Calcular margem de lucro
	 * 
	 * @param porcentagem deve ser informado como exemplo calcularMargemLucro(30), para 30%
	 */
	private double calcularMargemLucro(double porcentagem) {
		porcentagem /= 100;
		if (porcentagem >= 0.3 && porcentagem <= 0.8) {
			return this.precoCusto * porcentagem;
		} else {
			logger.log(Level.WARNING, "Porcentagem da margem de lucro incorreta, setando com o valor mínimo (30%)");
			return this.precoCusto * 0.3;
		}
	}

	/**
	 * Calcular imposto sobre o produto
	 * 
	 * @return imposto sobre valor do produto
	 */
	private double calcularImposto(double margemLucro) {
		valorImposto /= 100;
		return valorImposto * (precoCusto + margemLucro);
	}

	/**
	 * Realizar vendas
	 * 
	 * @param quantidadeProdutosVendidos quantidade vendida
	 */
	public void efetuarVenda(int quantidadeProdutosVendidos) {
		if (quantidadeProdutosVendidos > 0) {
			if (this.quantidadeEstoque - quantidadeProdutosVendidos < 0) {
				logger.log(Level.SEVERE, "Estoque insuficiente");
			} else {
				if (estoqueAbaixoDoMinimo()) {
					logger.log(Level.WARNING, "Estoque atual da mercearia abaixo do minimo");
				}
				removerEstoque(quantidadeProdutosVendidos);
				this.quantidadeTotalVendas += quantidadeProdutosVendidos;
				this.valorTotalVendas += calcularValorArrecadado(quantidadeProdutosVendidos); //valor total arrecadado com as vendas
			}
		} else {
			logger.log(Level.SEVERE, "Quantidade de vendas incorreto");
		}
	}

	private double calcularValorArrecadado(int quantidade) {
		return this.precoVenda * quantidade;
	}

	// monitora se a qtdAtual em estoque está abaixo do mínimo
	public boolean estoqueAbaixoDoMinimo() {
		if (this.quantidadeEstoque < 10)
			return true;
		return false;
	}

	/**
	 * Remove itens do estoque após realizar venda de produtos
	 * 
	 * @param quantidadeProdutosVendidos
	 */
	private void removerEstoque(int quantidadeProdutosVendidos) {
		this.quantidadeEstoque -= quantidadeProdutosVendidos;
	}

	/**
	 * Calcula a quantidade total de produtos comprados pela mercearia
	 * 
	 * @param quantidadeProdutosComprados (quantidade total de produtos adquiridos)
	 */
	public void efetuarCompra(int quantidadeProdutosComprados) {
		if (this.quantidadeEstoque + quantidadeProdutosComprados >= 10) {
			adicionarEstoque(quantidadeProdutosComprados);
			this.valorTotalCompra += calcularValorAquisicao(quantidadeProdutosComprados); //custos TOTAIS com a aquisição de um produto
		} else {
			adicionarEstoque(quantidadeProdutosComprados);
			this.valorTotalCompra += calcularValorAquisicao(quantidadeProdutosComprados);
			logger.log(Level.INFO, "Estoque minimo insuficiente, deve ser comprado um numero maior de itens para atingir o estoque minimo");
		}
	}

	private double calcularValorAquisicao(int quantidade) {
		return this.precoCusto * quantidade;
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
	// #endregion
}