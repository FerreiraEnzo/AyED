package Resoluciones.Practica2.Ejercicio7;

import Resoluciones.Practica2.Ejercicio1.BinaryTree;

public class Ejercicio7 {
	private BinaryTree<Integer> arbol;
	
	public Ejercicio7(BinaryTree<Integer>ab){
		this.arbol = ab;
	}
	
	public boolean isLeftTree(int num) {
		
		int cantIzq = -1;
		int cantDer = -1;
		BinaryTree<Integer> ab = new BinaryTree<Integer>();
		if(arbol != null && !arbol.isEmpty()) {
			ab = buscarNodo(arbol,num);
			if(!ab.isEmpty()) {
				if(ab.hasLeftChild()) 
					cantIzq = buscarRec(ab.getLeftChild());
				if(ab.hasRightChild())
					cantDer = buscarRec(ab.getRightChild());
			}else {
				return false;
			}	
		}
		return cantIzq > cantDer;
		
	}
		
	
		
	private int buscarRec(BinaryTree<Integer>ab) {
		
		int contador = 0;
		
		if(ab.hasLeftChild() && !ab.hasRightChild() || !ab.hasLeftChild() && ab.hasRightChild()) {
			contador++;
		}
		
		if(ab.isLeaf()) {
			return contador;
		}
		
		if(ab.hasLeftChild())
			contador += buscarRec(ab.getLeftChild());
		
		if(ab.hasRightChild())
			contador += buscarRec(ab.getRightChild());
	
		return contador;
	}
	
	public BinaryTree<Integer> buscarNodo(BinaryTree<Integer>arbol, int numero){
		
		if(arbol.getData() == numero) {
			return arbol;
		}
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>();
		
		if(arbol.hasLeftChild() && ab.isEmpty()){		//SI TIENE HI Y NO LO ENCONTRE TODAVÍA
			ab = buscarNodo(arbol.getLeftChild(),numero);
		}
		
		if(arbol.hasRightChild() && ab.isEmpty()) {	// SI TIENE HD Y NO LO ENCONTRE TODAVÍA
			ab = buscarNodo(arbol.getRightChild(),numero);
		}
		
		return ab;
	}
		
		
	}
	
	
	
	

