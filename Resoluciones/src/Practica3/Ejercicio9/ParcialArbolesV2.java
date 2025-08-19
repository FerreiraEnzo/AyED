package tp3.ejercicio9;

import java.util.Iterator;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class ParcialArbolesV2 {
	
	
	private boolean esDeSeleccionRec(GeneralTree<Integer> arbol) {
		
		if(arbol.isLeaf()) {
			return true;
		}
		
		List<GeneralTree<Integer>> children = arbol.getChildren();
		Iterator<GeneralTree<Integer>> iterador = children.iterator();
		
		int min = 9999;
		boolean ok = true;
		
		while(iterador.hasNext() && ok) {
			GeneralTree<Integer> hijo = iterador.next();
			if(hijo.getData() < min) 
				min = hijo.getData();
			
			ok = esDeSeleccion(hijo);
		}
		
		if(arbol.getData() != min)
			return false;
		
		return ok;
			
	}
		
	public boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		
		if(arbol.isEmpty())
			return false;
	
		return esDeSeleccionRec(arbol);
	}
	
	
	
	
	

}
