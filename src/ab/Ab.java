package ab;

public class Ab {
	
	private NodoAb raiz;

	public Ab(NodoAb unaRaiz) {
		this.raiz = unaRaiz; 
	}

	public int cantidadNodos() {
		return cantidadNodos(this.raiz);
	}

	private int cantidadNodos(NodoAb raiz) {
		if (raiz == null)
			return 0;

		return 1 + cantidadNodos(raiz.getIzquierda()) + cantidadNodos(raiz.getDerecha());
	}

	public int cantidadHojas() {
		return cantidadHojas(this.raiz);
	}

	private int cantidadHojas(NodoAb raiz) {
		if (raiz == null)
			return 0;

		if (raiz.getIzquierda() == null && raiz.getDerecha() == null)
			return 1;

		return cantidadHojas(raiz.getIzquierda()) + cantidadHojas(raiz.getDerecha());
	}

	public int peso() {
		return (this.raiz == null) ? 0 : cantidadNodos(this.raiz) - 1;
	}

	public int altura() {
		return altura(this.raiz);
	}

	private int altura(NodoAb raiz) {
		if (raiz == null)
			return -1;

		return 1 + Math.max(altura(raiz.getIzquierda()), altura(raiz.getDerecha()));
	}

	public boolean todosPares() {
		return todosPares(this.raiz);
	}

	private boolean todosPares(NodoAb raiz) {
		if (raiz == null)
			return true;

		return (raiz.getDato() % 2 == 0)
				&& todosPares(raiz.getIzquierda())
				&& todosPares(raiz.getDerecha());
	}

	public boolean iguales(Ab ab1, Ab ab2) {
		return iguales(ab1.raiz, ab2.raiz);
	}

	private boolean iguales(NodoAb raiz1, NodoAb raiz2) {
		if (raiz1 == null && raiz2 == null)
			return true;
		if (raiz1 == null || raiz2 == null)
			return false;
		if (raiz1.getDato() != raiz2.getDato())
			return false;

		return iguales(raiz1.getIzquierda(), raiz2.getIzquierda())
				&& iguales(raiz1.getDerecha(), raiz2.getDerecha());
	}
}
