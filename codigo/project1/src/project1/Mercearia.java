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
	
	private ListaDuplamenteEncadeada listaProdutos;
	
	/********************
		Contrutores
	********************/
	
	Mercearia(){
		 this.listaProdutos = new ListaDuplamenteEncadeada();
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
	 * @param descrição descrição do produto a ser adicionado
	 */
	public void adicionarProduto(String descrição) {
		Produto produto = new Produto(descrição);
		this.listaProdutos.inserirFim(produto);
	}
	
	/**
	 * @return lista duplamente encadeada com os produtos
	 */
	public ListaDuplamenteEncadeada getLista() {
		return this.listaProdutos;
	}

	
}
