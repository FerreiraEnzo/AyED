package RepasoGenerales;

import java.util.LinkedList;
import java.util.List;

public class Ejercicio7<T> {
	private GeneralTree<Integer> arbol;
	
	
	public Ejercicio7(GeneralTree<Integer>ab) {
		this.arbol = ab;
	}
	
	
	public List<Integer> caminoAHojaMasLejana(){
		
		List<Integer> resultado = new LinkedList<Integer>();
		
		if(arbol != null && !arbol.isEmpty()) {
			buscarCaminoRec(arbol,resultado,new LinkedList<Integer>());
		}
		
		return resultado;
	}
	
	
	private void buscarCaminoRec(GeneralTree<Integer>arbol,List<Integer>resultado,
									LinkedList<Integer>caminoActual) {
		
		caminoActual.add(arbol.getData());
		
		if(arbol.isLeaf()) {
			if(caminoActual.size() > resultado.size()) {
				resultado.clear();
				resultado.addAll(caminoActual);
			}
		}else {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child : children) {
				buscarCaminoRec(child, resultado, caminoActual);				
			}
		}
		
		caminoActual.remove(caminoActual.size()-1);
	
	}
	
				
	
	
	

}
