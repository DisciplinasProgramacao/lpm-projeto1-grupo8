/**
 * 
 */
package project1;

public class ListaEncadeada {

private Celula primeira;
private Celula ultimo;

public ListaEncadeada() {
		Celula sentinela;
		sentinela = new Celula();
		primeira = sentinela;
		ultimo = sentinela;
	}

	public void inserir(Produto produtoNovo) {
		Celula novaCelula = new Celula(produtoNovo);
		ultimo.setProximo(novaCelula);
		this.ultimo = novaCelula;
	}

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
	
	public int quantidadeProdutosEstoque() {
		int contador = 0;
		Celula celulaAux = primeira.getProximo();
		while(celulaAux != null) {
			contador++;
			celulaAux = celulaAux.getProximo();
		}
		return contador;
	}
	
	private boolean listaVazia() {
		return ultimo == primeira ? true : false; 
	}

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

	public double valorTotalEstoque() {
			
		Celula celulaAux = this.primeira.getProximo();
		double total = 0;
		while(celulaAux != null) {
			
			total += celulaAux.getItem().getValorTotalEstoque();
			
			celulaAux = celulaAux.getProximo();
		}
		return total;
	}
	
	
	
	
	
	
	
}