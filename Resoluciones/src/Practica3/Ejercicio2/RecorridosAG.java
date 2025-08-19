package RepasoGenerales;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import Resoluciones.Practica3.Ejercicio1.GeneralTree;

public class RecorridosAG {

	
	public List<Integer> numImparesMayoresQuePreOrden(GeneralTree<Integer> arbol, int n){
		
		
		List<Integer> lista = new LinkedList<Integer>(); 
		if(arbol != null && !arbol.isEmpty()) {
			numImparesMayoresRec(arbol,lista,n);
		}
		
		return lista;
	}
	
	private void numImparesMayoresRec(GeneralTree<Integer>arbol,
									List<Integer>lista, int n) {
		
		if(arbol.getData() % 2 != 0 && arbol.getData() > n)
			lista.add(arbol.getData());
		
		if(arbol.hasChildren()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			
			for(GeneralTree<Integer> hijo : children) {
				numImparesMayoresRec(hijo,lista, n);
			}
		}	
	}
	
	public List<Integer> numImparesMayoresQuePostOrden(GeneralTree<Integer>arbol,int n){
		
		List<Integer> lista = new LinkedList<Integer>();
		
		if(arbol != null && !arbol.isEmpty()) {
			numImparesRec(arbol,lista,n);
		}
		
		return lista;
	}
	
	private void numImparesRec(GeneralTree<Integer> arbol, List<Integer>lista,int n){
		
		if(arbol.hasChildren()){
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child : children) {
				numImparesRec(child, lista, n);
			}
		}	
		
			if(arbol.getData() % 2 !=0 && arbol.getData() > n)
				lista.add(arbol.getData());
	}
	
	
	public List<Integer> numImparesMayoresQuePorNiv(GeneralTree<Integer>arbol,int n){
		
		List<Integer> lista = new LinkedList<Integer>();
		
		if(arbol != null && !arbol.isEmpty()) {
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				GeneralTree<Integer> aux = cola.dequeue();
				if(aux != null) {
					if(aux.getData() % 2 != 0 && aux.getData() > n)
						lista.add(aux.getData());
					List<GeneralTree<Integer>> children = aux.getChildren();
					for(GeneralTree<Integer> child : children) {
						cola.enqueue(child);
					}
				}else {
					if(!cola.isEmpty()) 
						cola.enqueue(null);;
				}
			}
		}
		return lista;
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree <Integer> a, Integer n) {
        List<Integer> lista = new ArrayList();
        if(!a.isEmpty())
            numerosImparesMayoresQueInOrden(a,n,lista);
        return lista;
    }
	
	private void numerosImparesMayoresQueInOrden(GeneralTree <Integer> a, Integer n, List<Integer> lista) {
        if(a.hasChildren())
            numerosImparesMayoresQueInOrden(a.getChildren().getFirst(),n,lista);
        
        if(a.getData() > n && a.getData() % 2 != 0)
            lista.add(a.getData());
        
        for(int i=1; i< a.getChildren().size(); i++)
            numerosImparesMayoresQueInOrden(a.getChildren().get(i),n,lista);
    }
	
}
	
	


