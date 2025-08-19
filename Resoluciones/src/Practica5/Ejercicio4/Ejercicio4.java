package RepasoGrafos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Ejercicio4 {
	
	
	public List<String> paseoEnBici(Graph<String>grafo,String destino,int maxTiempo,
									List<String>lugaresRestringidos){
		
		List<String> camino = new LinkedList<String>();
		if(grafo != null && !grafo.isEmpty()) {
			boolean marca [] = new boolean[grafo.getSize()];
			Vertex<String> origen = grafo.search("Ayuntamiento");
			Vertex<String> dest = grafo.search(destino);
			marcarRestringidos(grafo,lugaresRestringidos,marca);
			
			if(origen != null && dest != null) {
				dfs(grafo,origen,dest,maxTiempo,camino,0,marca);
			}
		}
		return camino;
	}
	
	private void marcarRestringidos(Graph<String>grafo,List<String>lugaresRestringidos,
									boolean marca[]) {
		
		for(String lugar : lugaresRestringidos) {
			Vertex<String> v = grafo.search(lugar);
			int pos = v.getPosition();
			if(!marca[pos]) {
				marca[pos] = true; 
			}
		}
	}
	
	private boolean dfs(Graph<String>grafo,Vertex<String>origen,Vertex<String>destino,
						int maxTiempo,List<String>camino,int tiempoAct,boolean marca[]) {
		
		boolean encontre = false;
		marca[origen.getPosition()] = true;
		camino.add(origen.getData());
		
		if(origen == destino && tiempoAct <= maxTiempo) {	//NO ES NECESARIO LA CONDICION DEL TIEMPO
			return true;
		}else {
			List<Edge<String>> adyacentes = grafo.getEdges(origen);
			Iterator<Edge<String>> iterador = adyacentes.iterator();
			while(!encontre && iterador.hasNext() && tiempoAct <= maxTiempo) { //NO ES NECESARIO LA CONDICION DEL TIEMPO
				Edge<String> e = iterador.next();
				Vertex<String> w = e.getTarget();
				int pos = w.getPosition();
				int newTime = tiempoAct + e.getWeight();
				if(!marca[pos] && newTime < maxTiempo) {
					encontre = dfs(grafo,w, destino, maxTiempo, camino, newTime, marca);
				}
			}
		}
		
		if(!encontre)
			camino.remove(camino.size()-1);
		
		marca[origen.getPosition()] = false;
		return encontre;
	}
	
	
	

}
