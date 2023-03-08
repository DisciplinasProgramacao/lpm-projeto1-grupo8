/**
 * 
 */
package project1;

public class ListaEncadeada {

	// #region ATRIBUTOS	
	private Celula primeira;
	private Celula ultimo;
	// endregion 


	// #region CONSTRUTOR
	public ListaEncadeada() {
		Celula sentinela;
		sentinela = new Celula();
		primeira = sentinela;
		ultimo = sentinela;
	}
	// endregion 


	// #region METODOS	

	/**
	 * Insere novo produto da lista 
	 * 
	 * @param produtoNovo
	 */
	public void inserir(Produto produtoNovo) {
		Celula novaCelula = new Celula(produtoNovo);
		ultimo.setProximo(novaCelula);
		this.ultimo = novaCelula;
	}


	/**
	 * Verifica se o produto esta no estoque pelo seu ID
	 * 
	 * @return produto
	 */
	public Produto getProdutoPorID(int ID) throws Exception {
		Celula celulaEncontrada;
		if (! listaVazia()) {
			celulaEncontrada = this.primeira;
			while(celulaEncontrada != null) {
				if(celulaEncontrada.getItem().getID()==ID) {
					return celulaEncontrada.getItem();
				}else {
					celulaEncontrada = celulaEncontrada.getProximo();
				}
			}
			throw new Exception("Não foi possível encontrar o item na lista: o ID informado é inválido!");
		} else
			throw new NullPointerException("Não foi possível encontrar o item na lista: a lista está vazia!");
	}
	

	/**
	 * Calcula a quantidade de produtos existentes no estoque
	 * 
	 * @return quantidade de produtos
	 */
	public int quantidadeProdutosEstoque() {
		int contador = 0;
		Celula celulaAux = primeira.getProximo();
		while(celulaAux != null) {
			contador++;
			celulaAux = celulaAux.getProximo();
		}
		return contador;
	}
	
	//Confere se a lista esta vazia
	private boolean listaVazia() {
		return ultimo == primeira ? true : false; 
	}

	/**
	 * Remove produto do estoque
	 * 
	 * @param produto
	 */
	public void remover(Produto produto) {
		Celula celulaRemovida = null, celulaAux = this.primeira;
			while(celulaAux != null) {
				if(celulaAux.getProximo().getItem() == produto) {
					celulaRemovida = celulaAux.getProximo();
					break;
				}
				celulaAux = celulaAux.getProximo();
			}
			if(celulaRemovida != null) {
				if (celulaRemovida == ultimo) 
					celulaAux.setProximo(null);
				else
					celulaAux.setProximo(celulaRemovida.getProximo());
			}
			celulaRemovida.setProximo(null);
	}

	/**
	 * Verifica a quantidade de produtos abaixo do estoque mínimo
	 * 
	 * @return quantidade de produtos abaixo min
	 */
	public String produtosAbaixoMinimoEstoque() {
		Celula celulaAux = this.primeira.getProximo();
		String contador = "";
		while(celulaAux != null) {
			if(celulaAux.getItem().getQuantidadeEstoque() < 10) {
				contador += celulaAux.getItem().getDescricao();
				contador += " ";
			}
			celulaAux = celulaAux.getProximo();
		}
		if(contador != "")
			contador = contador.substring(0, contador.length() - 1);
		return contador;
	}

	/**
	 * Calcula o valor total em $$ dos produtos no estoque
	 * 
	 * @return total
	 */
	public double valorTotalEstoque() {
			
		Celula celulaAux = this.primeira.getProximo();
		double total = 0;
		while(celulaAux != null) {
			
			total += celulaAux.getItem().getValorTotalEstoque();
			
			celulaAux = celulaAux.getProximo();
		}
		return total;
	}
		
	//#endregion
}