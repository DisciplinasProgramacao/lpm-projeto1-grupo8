/**
 * 
 */
package project1;

/**
 * @author grupo8
 *
 */
public class Celula {


	private Produto item;
	private Celula proximo;

	public Celula(Produto novo) {
		item = novo;
		proximo = null;
	}
	
	public Celula() {
		item = new Produto();
		proximo = null;
	}

	public Produto getItem() {
		return item;
	}
	public void setItem(Produto item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}
