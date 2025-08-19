package Resoluciones.Practica2.Ejercicio9;

import Resoluciones.Practica2.Ejercicio1.BinaryTree;

public class Ejercicio9V3 {
	
	
	public BinaryTree<Obj>sumandDif(BinaryTree<Integer>arbol){
		
		BinaryTree<Obj> ab = new BinaryTree<Obj>();
		
		if(arbol != null && !arbol.isEmpty()) {		
			crearNuevo(arbol,ab,0,0);
		}
		
		
		return ab;
	}
	
	private BinaryTree<Obj> crearNuevo(BinaryTree<Integer>arbol, BinaryTree<Obj>ab,
									int suma,int diferencia) {
		
		suma = suma + arbol.getData();
		int padre = arbol.getData();
		Obj objeto = new Obj(suma, diferencia);
		ab.setData(objeto);
		
		if(arbol.isLeaf()) {
			return ab;
		
		}
		
		if(arbol.hasLeftChild()) {
			BinaryTree<Obj> hijoIzq = new BinaryTree<Obj>();
			ab.addLeftChild(hijoIzq);
			crearNuevo(arbol.getLeftChild(), ab.getLeftChild(),suma, 
						arbol.getLeftChild().getData() - padre);
		}
		
		if(arbol.hasRightChild()) {
			BinaryTree<Obj> hijoDer = new BinaryTree<Obj>();
			ab.addRightChild(hijoDer);
			crearNuevo(arbol.getRightChild(), ab.getRightChild(), suma,
						arbol.getRightChild().getData() - padre);
		}
		
		return ab;
		
	}
	
	
	private BinaryTree<Obj> crearNuevo2(BinaryTree<Integer>arbol,
										BinaryTree<Obj>ab, int padre, int suma){
		
		int datoActual = arbol.getData();
		Obj objeto = new Obj(suma, datoActual - padre);
		ab.setData(objeto);
		
		if(arbol.isLeaf()) {
			return ab;
		}
		
		if(arbol.hasLeftChild()) {
			BinaryTree<Obj> hijoIzq = new BinaryTree<Obj>();
			ab.addLeftChild(hijoIzq);
			crearNuevo2(arbol.getLeftChild(), ab.getLeftChild(), datoActual, suma + datoActual);
		}
		
		if(arbol.hasRightChild()) {
			BinaryTree<Obj> hijoDer = new BinaryTree<Obj>();
			ab.addLeftChild(hijoDer);
			crearNuevo2(arbol.getRightChild(), ab.getRightChild(), datoActual, suma + datoActual);
		}
		
		
		return ab;
		
		
	}
	
	

}
