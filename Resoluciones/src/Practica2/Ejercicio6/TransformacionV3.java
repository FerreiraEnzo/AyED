package Resoluciones.Practica2.Ejercicio6;

import Resoluciones.Practica2.Ejercicio1.BinaryTree;

public class TransformacionV3 {
	private BinaryTree<Integer>arbol;
	
	
	public TransformacionV3(BinaryTree<Integer>ab) {
		this.arbol = ab;
		
	}
	
	public BinaryTree<Integer> suma(){
		
		if(arbol != null && !arbol.isEmpty()) {
			sumar(arbol);
		}

		return arbol;
	}
	
	private int sumar(BinaryTree<Integer> arbol) {
		
		int sum = 0;
		
		if(arbol.isLeaf()) {
			sum = arbol.getData();
			arbol.setData(0);
			return sum;	
		}
		
		if(arbol.hasLeftChild()) 
			sum += sumar(arbol.getLeftChild());
			
		if(arbol.hasRightChild())
			sum += sumar(arbol.getRightChild());
			
		int actual = arbol.getData();
		arbol.setData(sum);
		return actual + sum;
		
	}		
		
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
		BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(8);
		hijoIzq.addLeftChild(new BinaryTree<Integer>(2));
		hijoIzq.addRightChild(new BinaryTree<Integer>(3));
		hijoDer.addRightChild(new BinaryTree<Integer>(6));
		hijoDer.addLeftChild(new BinaryTree<Integer>(5));
		ab.addLeftChild(hijoIzq);
		ab.addRightChild(hijoDer);
		TransformacionV3 a = new TransformacionV3(ab);
		//System.out.println(a.suma());
	}
	

	
		
}
		
	
	
	
	
	
	

