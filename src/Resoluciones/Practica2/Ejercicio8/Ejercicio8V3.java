package Resoluciones.Practica2.Ejercicio8;

import Resoluciones.Practica2.Ejercicio1.BinaryTree;

public class Ejercicio8V3 {

	
	
	public boolean esPrefijo(BinaryTree<Integer>arbol1,BinaryTree<Integer>arbol2) {
		
		boolean ok = false;
		
		if(arbol1 != null && arbol2 != null && !arbol1.isEmpty() && !arbol2.isEmpty()) {
			ok = esPrefijoRec(arbol1,arbol2);
		}
		
		return ok;
	}
	
	private boolean esPrefijoRec(BinaryTree<Integer>arbol1,BinaryTree<Integer>arbol2) {
		
		boolean okey = true;
		
		if(arbol1.hasLeftChild() && !arbol2.hasLeftChild() || !arbol1.hasLeftChild() &&
			arbol2.hasLeftChild() || arbol1.hasRightChild() && !arbol2.hasRightChild() ||
			!arbol1.hasRightChild() && arbol2.hasRightChild() || arbol1.getData() != arbol2.getData()) {
			
			okey = false;
			return okey;
		}
		
		if(arbol1.hasLeftChild() && arbol2.hasRightChild() && okey) {
			okey = esPrefijoRec(arbol1.getLeftChild(), arbol2.getLeftChild());
			
		}
		
		if(arbol1.hasRightChild() && arbol2.hasRightChild() && okey) {
			okey = esPrefijoRec(arbol1.getRightChild(), arbol2.getRightChild());
			
		}
		
		return okey;
	}
	
}
