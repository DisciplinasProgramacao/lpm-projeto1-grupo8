/**
 * 
 */
package project1;

/**
 * @author grupo8
 *
 */
public class Celula {

	/********************
		Atributos
	********************/
	private Produto item;
	private Celula proximo;
	private Celula anterior;
	
	/********************
		Contrutores
	********************/
	public Celula(Produto novo) {
		item = novo;
		proximo = null;
		anterior = null;
	}
	
	public Celula() {
		
		item = new Produto();
		proximo = null;
		anterior = null;
	}
	
	/********************
		Métodos
	********************/
	
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
	public Celula getAnterior() {
		return anterior;
	}
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
}
