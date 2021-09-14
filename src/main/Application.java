package main;

import ab.*;

public class Application {
	
	public static void main(String[] args) {

		System.out.println("Inicializo...");

		Ab Arbol = new Ab(new NodoAb(5, new NodoAb(7, new NodoAb(2, null, new NodoAb(3)), null), new NodoAb(12, null, new NodoAb(15))));
		Ab ArbolPar = new Ab(new NodoAb(6, new NodoAb(8, new NodoAb(2, null, new NodoAb(4)), null), new NodoAb(12, null, new NodoAb(16))));

		Ab ArbolParecido = new Ab(new NodoAb(5, new NodoAb(7, new NodoAb(2, null, new NodoAb(9)), null), new NodoAb(12, null, new NodoAb(15))));


		System.out.println("Cantidad de Nodos: " + Arbol.cantidadNodos());
		System.out.println("Cantidad de Hojas " + Arbol.cantidadHojas());
		System.out.println("Peso del Arbol: " + Arbol.peso());
		System.out.println("Altura del Arbol: " + Arbol.altura());
		System.out.println("Todos pares: " + Arbol.todosPares());

		System.out.println("Iguales: " + Arbol.iguales(ArbolPar, ArbolParecido));
		System.out.println("Iguales: " + Arbol.iguales(ArbolParecido, ArbolParecido));
	}

}
