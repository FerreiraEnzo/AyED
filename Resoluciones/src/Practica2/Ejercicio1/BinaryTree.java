package Resoluciones.Practica2.Ejercicio1;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree<T>{
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree() {
		super();
	}
	
	public BinaryTree(T data) {
		this.data = data;		
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	// preguntar antes de invocar si hasLeftChild()

	public BinaryTree<T> getLeftChild(){
		return leftChild;
	}
	
	// preguntar antes de invocar si hasRightChild()
	
	public BinaryTree<T> getRightChild(){
		return this.rightChild;
	}
	
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}
	
	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	public void removeLeftChild() {
		this.leftChild = null;		
	}
	
	public void removeRigthChild() {
		this.rightChild = null;		
	}
	
	public boolean isEmpty() {
		return(this.isLeaf() && this.getData() == null);
	}
	
	public boolean isLeaf() {
		return(!this.hasLeftChild() && !this.hasRightChild());		
	}
	
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	
	public String toString() {
		return this.getData().toString();
	}
	
	
	// Se procesa primero la raiz y luego sus hijos, izquierdo y derecho
	
	public void printPreOrden() {
		System.out.println(this.getData() + " / / /");
		if(this.hasLeftChild()) {
			this.getLeftChild().printPreOrden();
		}
		if(this.hasRightChild()) {
			this.getRightChild().printPreOrden();
		}
	}	
	
	public int contarHojas() {
		int cantHojas = 0;
		if(this.isEmpty()) 
			return 0;
		else 
			if(this.isLeaf()) 
				return 1;
			else {
				if(this.hasLeftChild()) {
					cantHojas+=this.getLeftChild().contarHojas();
				}
				if(this.hasRightChild()) {
					cantHojas+=this.getRightChild().contarHojas();
				}
			}
		return cantHojas;
	}
	
	/*public void entreNiveles(int n, int m) {
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		int nivel = 0;
		
		cola.enqueue(this);
		cola.enqueue(null);	// MARCA DE NIVEL
		
		while(!cola.isEmpty()) {
			ab = cola.dequeue;
			if(ab != null) {
				System.out.println(ab.getData());
				if(ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if(ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
			}else {
				if(!cola.isEmpty()) {
					System.out.println();
					cola.enqueue(null);
				}
			}
		}
	}	*/
	
	public void printLevelTraversal() {
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.offer(this);		//ENCOLO LA RAIZ
		cola.offer(null);		//MARCA DE NIVEL
		
		while(!cola.isEmpty()) {
			BinaryTree<T> ab = cola.poll();		//DESENCOLO
			if(ab != null) {
				System.out.println(ab.getData());
				if(ab.hasLeftChild()) {
					cola.offer(ab.getLeftChild());	//ENCOLO
				}
				if(ab.hasRightChild()) {
					cola.offer(ab.getRightChild());	//ENCOLO
				}
			}else if (!cola.isEmpty()) {
				System.out.println();
				cola.offer(null);	//MARCA DE NIVEL PARA EL SIGUIENTE NIVEL
			}
		}
		
	}
	
	public BinaryTree<T> espejo(){
		BinaryTree<T> a2 = new BinaryTree<T>(this.getData());
		
		if(this.hasLeftChild()) {
			a2.addRightChild(this.getLeftChild().espejo());
		}
		if(this.hasRightChild()) {
			a2.addLeftChild(this.getRightChild().espejo());
		}
	return a2;	
	}
	
	public void entreNiveles(int n, int m) {
		
		//1
   //2		   //3
//4    //5	//6 
		
		
		int nivel = 0;
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.offer(this);
		cola.offer(null);
		
		while(!cola.isEmpty()) {
			BinaryTree<T> a3 = cola.poll();
			if(a3 != null) {
				if(nivel >= n && nivel <=m){
					System.out.println(a3.getData());
				}
				if(a3.hasLeftChild()) {
					cola.offer(a3.getLeftChild());
				}
				if(a3.hasRightChild()) {
					cola.offer(a3.getRightChild());
				}
			}else if(!cola.isEmpty()) {
				nivel++;
				System.out.println();
				cola.offer(null);	//MARCA DE FIN DEL SIGUIENTE NIVEL 
			}
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree <Integer>(25);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		
		BinaryTree<Integer> hijoDerecho = new BinaryTree <Integer> (78);
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		ab.printLevelTraversal();
		System.out.println("La cantidad de hojas son: " + ab.contarHojas());
		
		//ESPEJO
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoLeft = new BinaryTree<Integer>(2);
		BinaryTree<Integer> hijoRight = new BinaryTree<Integer>(3);
		hijoLeft.addLeftChild(new BinaryTree<Integer>(4));
		hijoLeft.addRightChild(new BinaryTree<Integer>(5));
		hijoRight.addLeftChild(new BinaryTree<Integer>(6));
		arbol.addLeftChild(hijoLeft);
		arbol.addRightChild(hijoRight);
		System.out.println();
		System.out.println("ARBOL ESPEJO: ");
		BinaryTree<Integer> a2 = arbol.espejo();
		a2.printLevelTraversal();
		System.out.println("ACA EMPIEZA EL METODO:");
		arbol.entreNiveles(1,1);	//PROBANDO FUNCIONA
	}
	
			//1
	  //2		   //3
  //4    //5	//6   
	
}
	
		
	
	
