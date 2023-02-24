/**
 * 
 */
package project1;

public class ListaDuplamenteEncadeada {

	/********************
		Atributos
	********************/
	
	private Celula primeiro;
	private Celula ultimo;
	public int tamanho;
	
	/********************
		Contrutores
	********************/
	
	public ListaDuplamenteEncadeada() {
		
		Celula sentinela;
		
		sentinela = new Celula();
		
		primeiro = sentinela;
		ultimo = sentinela;
		
		tamanho = 0;
	}
	
	/********************
		Métodos
	********************/
	
	public boolean listaVazia() {
		
		boolean resp;
		
		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	public void inserir(Produto novo, int posicao) throws Exception {
		
		Celula anterior, novaCelula, proximaCelula;
		
		if ((posicao >= 0) && (posicao <= tamanho)) {
			anterior = primeiro;
			for (int i = 0; i < posicao; i++)
				anterior = anterior.getProximo();
				
			novaCelula = new Celula(novo);
			
			proximaCelula = anterior.getProximo();
			
			anterior.setProximo(novaCelula);
			novaCelula.setProximo(proximaCelula);
			
			if (posicao == tamanho)  // a inser��o ocorreu na �ltima posi��o da lista
				ultimo = novaCelula;
			
			tamanho++;
			
		} else
			throw new Exception("N�o foi poss�vel inserir o item na lista: a posi��o informada � inv�lida!");
	}
	public void inserirInicio(Produto novo) {
		try {
			inserir(novo, 0);
		} catch (Exception e) {;}
	}
	
	public void inserirFim(Produto novo) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(novo);
		
		ultimo.setProximo(novaCelula);
		novaCelula.setAnterior(ultimo);
		
		ultimo = novaCelula;
		
		tamanho++;
		
	}
	public Produto remover(int posicao) throws Exception {
		
		Celula anterior, celulaRemovida, proximaCelula;
		
		if (! listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				anterior = primeiro;
				for (int i = 0; i < posicao; i++)
					anterior = anterior.getProximo();
				
				celulaRemovida = anterior.getProximo();
				
				proximaCelula = celulaRemovida.getProximo();
				
				anterior.setProximo(proximaCelula);
				celulaRemovida.setProximo(null);
				
				if (celulaRemovida == ultimo)
					ultimo = anterior;
				
				tamanho--;
				
				return (celulaRemovida.getItem());	
			} else
				throw new Exception("N�o foi poss�vel remover o item da lista: a posi��o informada � inv�lida!");
		} else
			throw new Exception("N�o foi poss�vel remover o item da lista: a lista est� vazia!");
	} 
	
	/**
	 * método para encontrar o produto de acordo com sua posição
	 * @param posicao posição ao qual o produto se encontra na lista
	 * @return produto
	 */
	public Produto getProdutoPorPosição(int posicao) throws Exception {
		
		Celula anterior, celulaEncontrada;
		
		if (! listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				anterior = primeiro;
				for (int i = 0; i < posicao; i++)
					anterior = anterior.getProximo();
				
				celulaEncontrada = anterior.getProximo();			
				
				
				return (celulaEncontrada.getItem());	
			} else
				throw new Exception("Não foi possível remover o item da lista: a posição informada é inválida!");
		} else
			throw new Exception("Não foi possível encontrar o item da lista: a lista está vazia!");
	} 
	
	/**
	 * método para encontrar o produto de acordo com seu ID
	 * @param ID ID do produto o qual quer encontrar
	 * @return produto
	 */
	public Produto getProdutoPorID(Integer ID) throws Exception {
		
		Celula celulaEncontrada;
		
		if (! listaVazia()) {
			celulaEncontrada = this.primeiro;
			while(celulaEncontrada != null) {
				if(celulaEncontrada.getItem().getID()==ID) {
					return celulaEncontrada.getItem();
				}else {
					celulaEncontrada = celulaEncontrada.getProximo();
				}
			}
			throw new Exception("Não foi possível encontrar o item na lista: o ID informado é inválido!");
		} else
			throw new Exception("Não foi possível encontrar o item na lista: a lista está vazia!");
	} 
	
	public Produto removerInicio() throws Exception {
		return remover(0);
	}
	
	public Produto removerFim() throws Exception {
		
		Celula removida, penultima;
		
		if (! listaVazia()) {
			
			removida = ultimo;
			
			penultima = ultimo.getAnterior();
			penultima.setProximo(null);
			removida.setAnterior(null);
			
			ultimo = penultima;
			
			tamanho--;
			
			return (removida.getItem());
		} else
			throw new Exception("N�o foi poss�vel remover o �ltimo item da lista: a lista est� vazia!");
	}
	
	public void mostrar() throws Exception {
		
		Celula aux;
		if (! listaVazia()) {
			aux = primeiro.getProximo();
			while (aux != null) {
				System.out.print("");
				aux = aux.getProximo();
			}
		} else
			throw new Exception("N�o foi poss�vel imprimir o conte�do da lista: a lista est� vazia!");
	}

}
