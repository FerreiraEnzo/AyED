package Resoluciones.Practica2.Ejercicio3;

import java.util.LinkedList;

import Resoluciones.Practica2.Ejercicio1.BinaryTree;

public class ContadorArbolEj3 {
	private BinaryTree<Integer> a;
	
	public ContadorArbolEj3(BinaryTree<Integer> unArbol) {
		this.a = unArbol;
	}
	
	public LinkedList<Integer> numerosParesIN(){
		LinkedList<Integer> lista = new LinkedList<Integer>();
		
		if(!a.isEmpty()) {
			this.inOrden(lista,a);
		}
		return lista;
	}
			
	private void inOrden(LinkedList<Integer> l,BinaryTree<Integer> a) {
		if(a.hasLeftChild()) {
			inOrden(l,a.getLeftChild());
		}
		if(a.getData() % 2 == 0) {
			l.add(a.getData());
		}
		if(a.hasRightChild()) {
			inOrden(l,a.getRightChild());
		}
	}
		
	public LinkedList<Integer> numerosParesPO(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		if(!a.isEmpty()) {
			this.PostOrden(list,a);
		}
		return list;
	}
		
	
	private void PostOrden(LinkedList<Integer> list,BinaryTree<Integer> a) {
		if(a.hasLeftChild()) {
			PostOrden(list, a.getLeftChild());
		}
		if(a.hasRightChild()) {
			PostOrden(list, a.getRightChild());	
		}
		if(a.getData() % 2 == 0) {
			list.add(a.getData());
		}
	}
	
	
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(5);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(1));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(3));
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(2));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(9));
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		ContadorArbolEj3 c = new ContadorArbolEj3(ab);
		System.out.println("ARBOL ORIGINAL POR NIVELES: ");
		//c.printLevelTraversal();
		
		LinkedList<Integer> listIN = c.numerosParesIN();
		System.out.println("NODOS PARES DEL ARBOL INORDEN: ");
		System.out.println(listIN.toString());
		System.out.println();
		
		LinkedList<Integer> listPO = c.numerosParesPO();
		System.out.println("NODOS PARES DEL ARBOL POSTORDEN: ");
		System.out.println(listPO.toString());
		
					//10
			//4				 //5
		//1	  //3		 //2	//9		
		
	}
	
	
	
}
