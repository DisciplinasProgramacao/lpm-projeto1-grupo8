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
		ultimo.proximo = novaCelula;
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
				if(celulaEncontrada.item.getID()==ID) {
					return celulaEncontrada.item;
				}else {
					celulaEncontrada = celulaEncontrada.proximo;
				}
			}
			throw new Exception("Nao foi possivel encontrar o item na lista: o ID informado e invalido!");
		} else
			throw new Exception("Nao foi possivel encontrar o item na lista: a lista esta vazia!");
	}
	

	/**
	 * Calcula a quantidade de produtos existentes no estoque
	 * 
	 * @return quantidade de produtos
	 */
	public int quantidadeProdutosEstoque() {
		int contador = 0;
		Celula celulaAux = primeira.proximo;
		while(celulaAux != null) {
			contador++;
			celulaAux = celulaAux.proximo;
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
				if(celulaAux.proximo.item == produto) {
					celulaRemovida = celulaAux.proximo;
					break;
				}
				celulaAux = celulaAux.proximo;
			}
			if(celulaRemovida != null) {
				if (celulaRemovida == ultimo) 
					celulaAux.proximo = null;
				else
					celulaAux.proximo = celulaRemovida.proximo;
			}
			celulaRemovida.proximo = null;
	}

	/**
	 * Verifica a quantidade de produtos abaixo do estoque mínimo
	 * 
	 * @return quantidade de produtos abaixo min
	 */
	public String produtosAbaixoMinimoEstoque() {
		Celula celulaAux = this.primeira.proximo;
		StringBuilder contador = new StringBuilder("");
		while(celulaAux != null) {
			if(celulaAux.item.getQuantidadeEstoque() < 10) {
				contador.append(celulaAux.item.getDescricao());
				contador.append(", ");
			}
			celulaAux = celulaAux.proximo;
		}
		
		String envio = contador.toString();
		if(envio != "")
			envio = envio.substring(0, contador.length() - 2);
		return envio;
	}

	/**
	 * Calcula o valor total em $$ dos produtos no estoque
	 * 
	 * @return total
	 */
	public double valorTotalEstoque() {
			
		Celula celulaAux = this.primeira.proximo;
		double total = 0;
		while(celulaAux != null) {
			
			total += celulaAux.item.getValorTotalEstoque();
			
			celulaAux = celulaAux.proximo;
		}
		return total;
	}
	
	
	
	//pos tdd
	/**
	 * Verifica se o produto esta no estoque pela sua descricao
	 * 
	 * @return produto
	 */
	public Produto getProdutoPorDescricao(String desc) throws Exception {
		Celula celulaEncontrada;
		if (! listaVazia()) {
			celulaEncontrada = this.primeira;
			while(celulaEncontrada != null) {
				if(celulaEncontrada.item.getDescricao().equals(desc)) {
					return celulaEncontrada.item;
				}else {
					celulaEncontrada = celulaEncontrada.proximo;
				}
			}
			throw new Exception("Nao foi possivel encontrar o item na lista: a descricao informada e invalida!");
		} else
			throw new Exception("Nao foi possivel encontrar o item na lista: a lista esta vazia!");
	}


	public String listarProdutos() {
		Celula celulaAux = this.primeira.proximo;
		StringBuilder contador = new StringBuilder("");
		while(celulaAux != null) {
			contador.append(celulaAux.item.getDescricao());
			contador.append(", ");
			celulaAux = celulaAux.proximo;
		}
		
		String envio = contador.toString();
		if(envio != "")
			envio = envio.substring(0, contador.length() - 2);
		return envio;
	}
	
	public double valorTotalVendido() {
		
		Celula celulaAux = this.primeira.proximo;
		double total = 0;
		while(celulaAux != null) {
			
			total += celulaAux.item.getValorVendaTotal();
			
			celulaAux = celulaAux.proximo;
		}
		return total;
	}
	
	public double valorTotalReposicao() {
		
		Celula celulaAux = this.primeira.proximo;
		double total = 0;
		while(celulaAux != null) {
			
			total += celulaAux.item.getValorTotalReposicao();
			
			celulaAux = celulaAux.proximo;
		}
		return total;
	}
		
	//#endregion
}