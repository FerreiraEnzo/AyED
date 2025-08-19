package Resoluciones.Practica2.Ejercicio4;

import Resoluciones.Practica2.Ejercicio1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> red;
	
	
	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.red =  a;
	}
	
	public int retardoReenvio() {
		if(!red.isEmpty()) {
			return retardo(red);		
		}else {
			return 0;
		}
	}
	
	private int retardo(BinaryTree<Integer>red) {
		int time = 0;
		
		if(!red.isLeaf()) {
			if(red.getLeftChild().getData() > red.getRightChild().getData()) {
				time+=retardo(red.getLeftChild());
			}else {
				time+=retardo(red.getRightChild());
			}
		}
		return time;		
			}
		
		
public static void main(String[] args) {
	BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
	
	BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(5);
	BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(8);
	hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(3));
	hijoIzquierdo.addRightChild(new BinaryTree<Integer>(4));
	hijoDerecho.addLeftChild(new BinaryTree<Integer>(6));
	hijoDerecho.addRightChild(new BinaryTree<Integer>(7));
	ab.addLeftChild(hijoIzquierdo);
	ab.addRightChild(hijoDerecho);

	RedBinariaLlena red = new RedBinariaLlena(ab);
	
	System.out.println("El mayor retardo posible fue: " + red.retardoReenvio() + "segundos");

							//10 
					//5				//8
				//3		//4		//6		//7
	}
}