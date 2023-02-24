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
		M�todos
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
	 * @param descri��o descri��o do produto a ser adicionado
	 */
	public void adicionarProduto(String descricao) {
		Produto produto = new Produto(descricao);
		this.listaProdutos.inserirFim(produto);
	}
	
	/**
	 * @return lista duplamente encadeada com os produtos
	 */
	public ListaDuplamenteEncadeada getLista() {
		return this.listaProdutos;
	}

	
}
