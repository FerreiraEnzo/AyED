package tp3.ejercicio11;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles11 {
	
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		
		if(arbol.isEmpty()) {
			return false;
		}
		
		boolean ok = true;
		
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTreer<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
				
		int cantNodos = 0;
		int valorActual = 1;
		
		while(!cola.isEmpty() && ok) {
			GeneralTree<Integer> aux = cola.dequeue();
			if(aux != null) {
				List<GeneralTree<Integer>> children = aux.getChildren();
					for(GeneralTree<Integer> hijo : children) {
						cola.enqueue(hijo);
						cantNodos++;
					}	
			}else{
				if(!cola.isEmpty()) {
					if(cantNodos == valorActual +1) {
						valorActual = cantNodos;
						cola.enqueue(null);
						cantNodos = 0;
					}else {
						ok = false;
					}
				}
			}
	}
		return ok;
	
	}
	
	
	
}
