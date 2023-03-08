/**
 * 
 */
package project1;

/**
 * @author grupo8
 *
 */
public class Celula {

	// #region ATRIBUTOS	
	private Produto item;
	private Celula proximo;
	// endregion 


	// #region CONSTRUTOR
	public Celula(Produto novo) {
		item = novo;
		proximo = null;
	}
	
	public Celula() {
		item = new Produto();
		proximo = null;
	}
	// endregion 


	// #region GET e SET 
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
	// endregion 
}
