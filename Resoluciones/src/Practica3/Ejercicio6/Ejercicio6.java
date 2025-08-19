package RepasoGenerales;

import java.util.List;

public class Ejercicio6 {
	private GeneralTree<Character> arbol;
	
	
	
	public double minimoCaudal(double caudal) {
		
		if(arbol == null || arbol.isEmpty())
			return -1;
		
		double min = 9999;
		min = buscarRec(arbol,caudal);
			
		return min;	
			
		}
		
	private double buscarRec(GeneralTree<Character>arbol, double caudal) {
	
		if(arbol.isLeaf()) {
			return caudal;
		}
		
		double min = 9999;
		
		List<GeneralTree<Character>> children = arbol.getChildren();
		caudal = caudal / children.size();
		for(GeneralTree<Character> child : children) {
			double resultado = buscarRec(child, caudal);	//CAUDAL DE CADA HIJO
			min = Math.min(min, resultado);		// ME QUEDO CON EL MINIMO DE CADA HOJA
		}
		
		return min;
	}	
		
	}
	
	
	
	
	
	
	


