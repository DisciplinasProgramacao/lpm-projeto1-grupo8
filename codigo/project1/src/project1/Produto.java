package project1;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @author 
 * Arthur Jansen Oliveira
 * Bárbara Mattioly Andrade
 * Gabriel Pimentel Tabatinga
 * Henrique Grissi C Soeiro de Carvalho
 * Laura Enísia Rodrigues Melo
 * 
 * 
 * @version 0.1
 *
 */
public class Produto {
	private final Logger logger = Logger.getLogger(Produto.class.getName());
	// #region ATRIBUTOS
	private static int parseID;
	private int ID;
	protected String descricao; // Deve possuir um minimo de 3 caracteres
	private int quantidadeEstoque; // Quantidade minima de cada produto = 10 itens
	private int quantidadeTotalComprada;
	private int quantidadeTotalVendas;
	private double valorTotalVendas;
	private double valorTotalCompra;
	private static double valorImposto;
	private double precoVenda;
	private double precoCusto;
	private double margemLucro;
	static {
		parseID = 0;
		valorImposto = 0.18;
	}
	// #endregion

	// #region GETS
	public int getID() {
		return this.ID;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public double getValorTotalEstoque() {
		return precoCusto * quantidadeEstoque;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public double getValorVendaTotal() {
		return valorTotalVendas;
	}
	
	public double getValorTotalReposicao() {
		return valorTotalCompra;
	}
	
	public int getQuantidadeTotalComprada() {
		return quantidadeTotalComprada;
	}

	public int getQuantidadeTotalVendas() {
		return quantidadeTotalVendas;
	}	

	// #endregion

	// #region CONSTRUTORES
	private void init(String descricao, int quantidadeTotalAdquirida, double precoCusto, double margemLucro) {
		this.ID = parseID++;
		this.descricao = descricao;
		this.quantidadeEstoque = 0;
		this.quantidadeTotalComprada = 0;
		this.quantidadeTotalVendas = 0;
		this.valorTotalVendas = 0;
		this.valorTotalCompra = 0;
		this.precoCusto = precoCusto;
		this.margemLucro = margemLucro;
		if (margemLucro > 0)
			this.precoVenda = calcularPrecoDeVendaUnitario();
		if (quantidadeTotalAdquirida >= 10)
			efetuarCompra(quantidadeTotalAdquirida);
	}

	public Produto() {
		init("abc", 0, 0, 0);
	}

	public Produto(String descricao, int quantidadeTotalAdquirida, double precoCusto, double margemLucro) {
		init(descricao, quantidadeTotalAdquirida, precoCusto, margemLucro);
	}
	// #endregion

	// #region Metodos

	/**
	 * Altera a descricao de um produto 
	 * 
	 * @param descricao
	 */
	public void alterarDescricao(String descricao) {
		if (descricao != null) {
			if (descricao.length() < 3) {
				System.out.print("A descrição é obrigatória e deve possuir no mínimo 3 caracteres");
			}
		}
		this.descricao = descricao;
	}

	/**
	 * Altera a preco de custo de um produto 
	 * 
	 * @param precoCusto
	 */
	public void alterarPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	/**
	 * Calcular preco de venda de um produto de acordo com a margem de lucro informada
	 * 
	 * @return preco de venda do produto
	 */
	public double calcularPrecoDeVendaUnitario() {
		double margemLucroCalculada = calcularMargemLucro(this.margemLucro);
		return this.precoCusto + calcularImposto(margemLucroCalculada) + margemLucroCalculada;
	}

	/**
	 * Metodo interno responsavel por calcular a margem de lucro
	 * Retorna o calculo com a margem de lucro minima caso receber valor invalido
	 * 
	 * @param porcentagem deve ser informado, como exemplo calcularMargemLucro(30), para 30%
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
	 * Metodo interno responsavel por calcular o imposto sobre o produto
	 * 
	 * @return imposto sobre valor do produto
	 */
	private double calcularImposto(double margemLucro) {
		return (valorImposto * (precoCusto + margemLucro));
	}

	/**
	 * Metodo que realiza as vendas dos produtos na mercearia
	 * 
	 * @param quantidadeProdutosVendidos quantidade vendida
	 */
	public double efetuarVenda(int quantidadeProdutosVendidos) {
		if (quantidadeProdutosVendidos > 0) {
			this.precoVenda = calcularPrecoDeVendaUnitario();
			if (this.quantidadeEstoque - quantidadeProdutosVendidos < 0) {
				logger.log(Level.WARNING, "Venda nao efetuada, estoque insuficiente");
				return 0.0;
			} else {
				if (estoqueAbaixoDoMinimo()) {
					logger.log(Level.WARNING, "Estoque atual da mercearia abaixo do minimo");
				}
				removerEstoque(quantidadeProdutosVendidos);
				this.quantidadeTotalVendas += quantidadeProdutosVendidos;
				double valorVendaAtual = calcularValorArrecadado(quantidadeProdutosVendidos); // valor da venda ATUAL do produto
				this.valorTotalVendas += valorVendaAtual; // valor TOTAL arrecadado com todas as vendas do produto
				return valorVendaAtual;
			}
		} else {
			logger.log(Level.SEVERE, "Quantidade de produtos sendo vendidos incorreta");
			return 0.0;
		}
	}

	/**
	 * Calcula o valor arrecadado pela mecearia, a partir da quantidade de produtos e o preco de venda
	 * 
	 * @param quantidade
	 */
	private double calcularValorArrecadado(int quantidade) {
		return this.precoVenda * quantidade;
	}

	// monitora se a quantidade atual em estoque esta abaixo do minimo
	public boolean estoqueAbaixoDoMinimo() {
		if (this.quantidadeEstoque < 10)
			return true;
		return false;
	}

	/**
	 * Remove itens do estoque apos realizar venda de produtos
	 * 
	 * @param quantidadeProdutosVendidos
	 */
	private void removerEstoque(int quantidadeProdutosVendidos) {
		this.quantidadeEstoque -= quantidadeProdutosVendidos;
	}

	/**
	 * Calcula a quantidade total de produtos comprados pela mercearia, recebendo a quantidade total de produtos adquiridos
	 * 
	 * @param quantidadeProdutosComprados
	 */
	public double efetuarCompra(int quantidadeProdutosComprados) {
		double valorAquisicaoAtual;
		if (quantidadeProdutosComprados > 0) {
			if (this.quantidadeEstoque + quantidadeProdutosComprados >= 10) {
				adicionarEstoque(quantidadeProdutosComprados);
				valorAquisicaoAtual = calcularValorAquisicao(quantidadeProdutosComprados); // valor sendo gasto no MOMENTO para comprar o produto
				this.valorTotalCompra += valorAquisicaoAtual; // custos TOTAIS com a aquisição de um produto
				return valorAquisicaoAtual;
			} else {
				adicionarEstoque(quantidadeProdutosComprados);
				valorAquisicaoAtual = calcularValorAquisicao(quantidadeProdutosComprados);
				this.valorTotalCompra += valorAquisicaoAtual;
				logger.log(Level.WARNING,
						"Compra efetuada, porém quantidade atual de itens em estoque é abaixo do mínimo recomendado, deve ser efetuada a compra de mais produtos!");
				return valorAquisicaoAtual;
			}
		} else {
			logger.log(Level.SEVERE, "Quantidade de produtos sendo comprados incorreta");
			return 0.0;
		}

	}

	/**
	 * Calcula o valor de de um produto adiquirido a partir do seu preco de custo 
	 * 
	 * @param quantidade
	 */
	private double calcularValorAquisicao(int quantidade) {
		return this.precoCusto * quantidade;
	}

	/**
	 * Adiciona itens no estoque apos a compra de novos produtos
	 * 
	 * @param quantidadeProdutosComprados
	 */
	private void adicionarEstoque(int quantidadeProdutosComprados) {
		this.quantidadeEstoque += quantidadeProdutosComprados;
		this.quantidadeTotalComprada += quantidadeProdutosComprados;
	}
	

	/**
	 * Mostra as informacoes de um produto
	 * 
	 * @param listarInformacoesProduto
	 */
	public String listarInformacoesProduto() {
		StringBuilder infos = new StringBuilder("");
		infos.append("ID: " + this.ID + "\nDescricao: " + this.descricao + "\nQuantidade em estoque: " + this.quantidadeEstoque + "\nQuantidade total comprada: " + this.quantidadeTotalComprada + "\nQuantidade total vendida: " + this.quantidadeTotalVendas + "\nValorTotalVendas: " + this.valorTotalVendas + "\nPreco custo: " + this.precoCusto + "\nPreco venda: " + this.precoVenda);	
		return infos.toString();
	}
	// #endregion
}