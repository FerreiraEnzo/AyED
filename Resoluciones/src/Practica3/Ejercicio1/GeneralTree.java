package tp3.ejercicio1;

import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio3.AnalizadorArbol;

import java.util.IllegalFormatCodePointException;
import java.util.Iterator;
import java.util.LinkedList;


public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
	}
	
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public List<Integer> imparesMayoresQuePreOrden(Integer n){
		List<Integer> miLista = new LinkedList<Integer>();
		
		if(this.isEmpty()) {
			return miLista;
		}
		numImparesRecPreOrder(n,miLista);
		return miLista;
	}
	
	private void numImparesRecPreOrder(Integer n, List<Integer> miLista) {
		int dato = (Integer) this.getData();
		
		if(dato % 2 != 0 && dato > n) {
			miLista.add(dato);
		}
		
		List<GeneralTree<T>> childrens = this.getChildren();
		for(GeneralTree<T> child : childrens) {
			child.numImparesRecPreOrder(n, miLista);
		}
	}
	
	public List<Integer> imparesMayoresQuePostOrden(Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		
		if(this.isEmpty()) {
			return lista;
		}
		numImparesRecPostOrder(n,lista);
		return lista;
	}
	
	private void numImparesRecPostOrder(Integer n, List<Integer> lista) {
		
		List<GeneralTree<T>> childrens = this.getChildren();
		for(GeneralTree<T> hijo : childrens) {
			hijo.numImparesRecPostOrder(n,lista);
		}
		
		int date = (Integer)this.getData();
		if(date % 2 != 0 && date > n) {
			lista.add(date);
		}
	}
	
	public List<Integer> numImparesMayoresQueInOrden(Integer n){
		List<Integer> myList = new LinkedList<Integer>();
		
		if(this.isEmpty()) {
			return myList;
		}
		numImparesMayoresQueInOrden(n,myList);
		return myList;
	}
	
	private void numImparesMayoresQueInOrden(Integer n, List<Integer> myList){
		List<GeneralTree<T>> childrens = this.getChildren();
		

		if(this.hasChildren()) {
			this.children.get(0).numImparesMayoresQueInOrden(n,myList);
		}
		
		Integer dato = (Integer) this.getData();
		if(dato % 2 != 0 && dato > n) {
			myList.add(dato);
		}
		
		for(GeneralTree<T> child : childrens) {
			child.numImparesMayoresQueInOrden(n,myList);
		}
	}
	
	
	public List<Integer> numImparesMayoresQuePorNiveles(Integer n){
		List<Integer> result = new LinkedList<Integer>();
		
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		while(!cola.isEmpty()) {
			GeneralTree<T> aux = cola.dequeue();
			Integer dato = (Integer)aux.getData();
			if(dato % 2 != 0 && dato > n) {
				result.add(dato);
			}
			List<GeneralTree<T>> childrens = aux.getChildren();
			for(GeneralTree<T> hijo : childrens) {
				cola.enqueue(hijo);
			}
		}				//CONSULTAR
		return result;
	}
	
	
	public int altura() {	
		
		if(this.isEmpty()) {
			return 0;
		}
		
		int alt = -1;
		List<GeneralTree<T>> childrens = this.getChildren();
		for(GeneralTree<T> hijo : childrens) {
			if(hijo.altura() > alt) {
				alt = hijo.altura();
			}
		}
			return alt + 1;
	}
	
	
	
	public int nivel(T dato){
		
		int nivel = 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<T> aux = cola.dequeue();
			if(aux != null) {
				nivel++;
				if(aux.getData().equals(dato)){
					return nivel;
				}
				if(aux.hasChildren()) {
					List<GeneralTree<T>> childrens = aux.getChildren();
					for(GeneralTree<T> hijo : childrens) {
						cola.enqueue(hijo);
					}
				}	
			}else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
				}
			}
		}
		return -1;		//NO EXISTE EL DATO EN EL ARBOL
	}

	public int ancho(){
			if(this.isEmpty()) {
				return 0;
			}
			
			Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			int nivel = 0;
			int maxNodos = -1;
			int maxNivel=-1;
			int cantNodos = 0;
			cola.enqueue(this);
			cola.enqueue(null);
			
			while(!cola.isEmpty()) {
				GeneralTree<T> aux = cola.dequeue();
				if(aux != null) {
					List<GeneralTree<T>> children = aux.getChildren();
					cantNodos+= children.size();
					for(GeneralTree<T> child : children) {
						cola.enqueue(child);
						cantNodos++;
					}
				}else {
					if(!cola.isEmpty()) {
						cola.enqueue(null);	//MARCA DE FIN DE NIVEL
						if(cantNodos > maxNodos) {
							maxNodos = cantNodos;
							maxNivel = nivel;
						}
						cantNodos = 0;
						nivel++;
						cola.enqueue(null);
					}
				}
			}
			return maxNodos;		
	}
	
	
	private GeneralTree<T> buscara(T a,GeneralTree<T> arbol){
		
		if(arbol.getData().equals(a)) {
			return arbol;
		}
		
		List<GeneralTree<T>> children = arbol.getChildren();
		Iterator<GeneralTree<T>> it = children.iterator();
		GeneralTree<T> auxiliar = null;	
		
		while(it.hasNext() && auxiliar == null) {
			auxiliar = buscara(a, it.next());//LLAMO CON EL SIG ELEMENTO
			}
		return auxiliar;
	}
		
	
	
	private boolean buscarb(T b, GeneralTree<T> ab) {
		boolean ok = false;
		
		if(ab.getData().equals(b)) {
			ok = true;
			return ok;
		}
		
		List<GeneralTree<T>> hijos = ab.getChildren();
		Iterator<GeneralTree<T>> ite = hijos.iterator();
		while(ite.hasNext() && ok == false) {
			ok = buscarb(b, ite.next());
			}
		return ok;	
		}
	
	
	
	public boolean esAncestro(T a, T b) {
		
		if(this.isEmpty()) {
			return false;
		}
		
		boolean aux = false;
		GeneralTree<T> ab = buscara(a,this);
		if(ab != null) {
			aux = buscarb(b,ab);
		}
		return aux;
	}

	public int alturaV2() {
		
		if(this.isEmpty()) 
			return -1;
		
		int alt = -1;
		for(GeneralTree<T> hijo : children) {
			if(hijo.alturaV2() > alt)
				alt = hijo.alturaV2();
		}
		
		return alt +1;
	
	}
	
	public GeneralTree<T> buscarC(T c,GeneralTree<T> arb){
		
		if(arb.getData().equals(c))
			return arb;
		
		for(GeneralTree<T> hijo : arb.getChildren()) {
			buscarC(c, arb);
	}
		return arb;
	}
	
	
	
	
	
	}
	