package Resoluciones.Practica2.Ejercicio5;

import Resoluciones.Practica1.Ejercicio8.Queue;
import Resoluciones.Practica2.Ejercicio1.BinaryTree;

public class ProfundidadArbolBinario {
	private BinaryTree<Integer> arbol;
	
	
	public int sumaElementosProfundidad(int p) {
		
		if(arbol == null || arbol.isEmpty()) {
			return -1;
		}
		
		int suma = 0;
		int nivel = 0;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			BinaryTree<Integer> aux = cola.dequeue();
			if(aux != null) {
				if(nivel == p) {
					suma += aux.getData();
				}
				if(aux.hasLeftChild()) 
					cola.enqueue(aux.getLeftChild());
				if(aux.hasRightChild())
					cola.enqueue(aux.getRightChild());
			}else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
			}
			}
		}
		return suma;
	}
	
	
	
	
	
	
	

}
