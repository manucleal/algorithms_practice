package grafo;

public class Grafo {
	private int tope;
	private int cantidad; 
	private String[] vertices;
	private Arista[][] matAdy;
		// Fila: Arista entrante.
		// Columna: Arista saliente.
	
	public Grafo(int unTope) {
		this.tope = unTope;
		this.vertices = new String[tope];
		this.matAdy = new Arista[tope][tope];
		for (int i = 0; i < tope; i++) {
			for (int j = 0; j < tope; j++) {
				this.matAdy[i][j] = new Arista();
			}
		}
	}
	
	public boolean esLleno() {
		return this.cantidad == this.tope;
	}
	
	public boolean esVacio() {
		return this.cantidad == 0;
	}
	
	//PRE: !esLleno()
	private int obtenerPosLibre() {
		for (int i = 0; i < this.tope; i++) {
			if (vertices[i] == null) return i;
		}
		return -1;
	}

	public int obtenerPos(String vert) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].equals(vert)) return i;
		}
		return -1;
	}
	
	//PRE: !esLleno && !existeVertice
	public void agregarVertice(String vert) {
		this.vertices[obtenerPosLibre()] = vert;
		this.cantidad++;
	}
	
	//PRE: existeVertice
	public void borrarVertice(String vert) {
		int posBorrar = obtenerPos(vert);
		// Primero, borro vertice.
		this.vertices[posBorrar] = null;
		this.cantidad--;
		// Despues, elimino sus aristas.
		for (int i = 0; i < tope; i++) {
			this.matAdy[posBorrar][i].setExiste(false); // Borra fila.
			this.matAdy[i][posBorrar].setExiste(false); // Borra columna.
		}
	}

	public boolean existeVertice(String vert) {
		return obtenerPos(vert) != -1;
	}
	
	//PRE: existeVertice(Origen) && existeVertice(destino) && !existeArista
	public void agregarArista(String origen, String destino, int peso) {
		int posOrigen = obtenerPos(origen);
		int posDestino = obtenerPos(destino);
		
		Arista a = this.matAdy[posOrigen][posDestino];
		a.setExiste(true);
		a.setPeso(peso);
	}

	//PRE: existeVertice(Origen) && existeVertice(destino)
	public boolean existeArista(String origen, String destino, int peso) {
		int posOrigen = obtenerPos(origen);
		int posDestino = obtenerPos(destino);
		return this.matAdy[posOrigen][posDestino].isExiste();
	}
	
	//PRE: existeVertice(Origen) && existeVertice(destino) && existeArista
	public void borrarArista(String origen, String destino) {
		int posOrigen = obtenerPos(origen);
		int posDestino = obtenerPos(destino);
		
		Arista a = this.matAdy[posOrigen][posDestino];
		a.setExiste(false);
	}
}
