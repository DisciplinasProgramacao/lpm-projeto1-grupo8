/**
 * 
 */
package project1;

/**
 * @author grupo8
 * @version 0.1
 *
 */
public class Mercearia {
	
	/********************
		Atributos
	********************/
	private String nome;
	
	private ListaEncadeada listaProdutos;
	
	/********************
		Contrutores
	********************/
	
	Mercearia(){
		 this.listaProdutos = new ListaEncadeada();
	}
	
	/********************
		Métodos
	********************/
	
	/**
	 * @return nome da Mercearia
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome da Mercearia
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param descricao do produto a ser adicionado
	 */
	//EM PROGRESSO
	public void adicionarProduto(String descricao, double precoCusto, double margemLucro, int quantidadeTotalAdquirida) {
		Produto produto = new Produto(descricao, quantidadeTotalAdquirida, precoCusto, margemLucro);
		this.listaProdutos.inserir(produto);
	}

	/**
	 * @return lista duplamente encadeada com os produtos
	 */
	public ListaEncadeada getLista() {
		return this.listaProdutos;
	}
	
	
}
