package project1;
public class Celula {

	// #region ATRIBUTOS	
	public Produto item;
	public Celula proximo;
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

}
