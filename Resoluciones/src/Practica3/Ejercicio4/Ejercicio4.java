package RepasoGenerales;

import java.util.List;

import RepasoGenerales.Ej8.Queue;
import RepasoGenerales.Ejercicio8Queue;
import Resoluciones.Practica3.Ejercicio1.GeneralTree;
import Resoluciones.Practica3.Ejercicio1.GeneralTree;
import Resoluciones.Practica3.Ejercicio1.GeneralTree;

import Resoluciones.Practica3.Ejercicio1.GeneralTree;


public class Ejercicio4 {
	
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		
		if(arbol == null || arbol.isEmpty())
			return -1;
		
		double maxPromedio = -1;
		double promNivel = 0;
		double tiempoNivel = 0;
		int cantNodosNivel = 0;
		
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> aux = cola.dequeue();
			if(aux != null) {
				tiempoNivel += aux.getData().getTardanza();
				cantNodosNivel++;
				List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
				for(GeneralTree<AreaEmpresa> child : children) {
					cola.enqueue(child);
				}
			}else {
				if(!cola.isEmpty()) {
					promNivel = tiempoNivel/cantNodosNivel;
					if(promNivel > maxPromedio)
						maxPromedio = promNivel;
					cantNodosNivel = 0;
					tiempoNivel = 0;
					promNivel = 0;
					cola.enqueue(null);
				}
			}
		}
		
		return maxPromedio;
	}
	
	
	
	

}


