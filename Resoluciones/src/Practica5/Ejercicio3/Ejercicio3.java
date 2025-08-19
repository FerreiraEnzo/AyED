package RepasoGrafos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Ejercicio3 {
	private Graph<String> mapaCiudades;

	
	
	public void setMapaCiudades(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	public Graph<String> getMapaCiudades() {
		return mapaCiudades;
	}
	
	
	public List<String> devolverCamino(String ciudad1,String ciudad2){
		
		List<String> camino = new LinkedList<String>();
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			boolean marca [] = new boolean[mapaCiudades.getSize()];
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			
			if(origen != null && destino != null) {
				dfs(origen,destino,camino,marca);
			}
		}
		
		return camino;
	}
	
	private boolean dfs(Vertex<String>origen,Vertex<String>destino,List<String>camino,
						boolean marca[]) {
		
		boolean encontre = false;
		marca[origen.getPosition()] = true;
		camino.add(origen.getData());
		
		if(origen == destino) {
			return true;
		}else {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> iterador = adyacentes.iterator();
			while(!encontre && iterador.hasNext()) {
				Edge<String> e = iterador.next();
				Vertex<String> v = e.getTarget();
				int pos = v.getPosition();
				if(!marca[pos]) {
					encontre = dfs(v, destino, camino, marca);
				}
			}
		}
		
		if(!encontre) {
			camino.remove(camino.size()-1);		
		}
	
		return encontre;
		
	}
	
					//EJERCICIO 3)2)
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
									List<String> ciudades){
		
		List<String> lista = new LinkedList<String>();
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			boolean marca [] = new boolean[mapaCiudades.getSize()];
			marcarCiudades(ciudades,marca);
			
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen != null && destino != null) {
				buscarCamExceptuando(origen, destino, lista, marca);
			}
		}
	
		return lista;	
	}
	
	
	private boolean buscarCamExceptuando(Vertex<String>origen,Vertex<String>destino,
										List<String> lista,boolean marca[]) {
		
		boolean encontre = false;
		marca[origen.getPosition()] = true;
		lista.add(origen.getData());
		
		if(origen == destino) {
			return true;
		}else {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> iterador = adyacentes.iterator();
			while(!encontre && iterador.hasNext()) {
				Edge<String> e = iterador.next();
				Vertex<String> w = e.getTarget();
				int pos = w.getPosition();
				if(!marca[pos])
					encontre = dfs(w, destino, lista, marca);
			}
		}
		
		if(!encontre)
			lista.remove(lista.size()-1);
		
		return encontre;
	}
	
	
	private void marcarCiudades(List<String> ciudades, boolean marca[]){
		
		for(String ciudad : ciudades) {
			Vertex<String> v = mapaCiudades.search(ciudad);
			if(!marca[v.getPosition()])
				marca[v.getPosition()] = true;
		}
	}
	
	
						//EJERCICIO 3)3)
	
	public List<String> caminoMasCorto(String ciudad1,String ciudad2){
		
		List<String> resultado = new LinkedList<String>();
		if(mapaCiudades!= null && !mapaCiudades.isEmpty()) {
			boolean marca [] = new boolean[mapaCiudades.getSize()];
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			
			if(origen != null && destino != null) {
				buscarCaminoMasCorto(origen, destino, resultado, marca,
									new LinkedList<String>(),Integer.MAX_VALUE,0);
			}
		}
		
		return resultado;
	}
	
	private int buscarCaminoMasCorto(Vertex<String>origen,Vertex<String>destino,
				List<String>resultado,boolean marca[], List<String> caminoActual,
				int min,int sumaActual) {
		
		marca[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		
		if(origen == destino && sumaActual < min) {
			min = sumaActual;
			resultado.clear();
			resultado.addAll(caminoActual);
		}else {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> iterador = adyacentes.iterator();
			while(iterador.hasNext() && sumaActual < min) {
				Edge<String> e = iterador.next();
				Vertex<String> w = e.getTarget();
				int pos = w.getPosition();
				int nuevoAct = sumaActual + e.getWeight();
				if(!marca[pos] && nuevoAct < min) {
					min = buscarCaminoMasCorto(w, destino, resultado, marca, 
										caminoActual,min, nuevoAct);
				}
			}
		}
		
		marca[origen.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
		return min;
		
	}
	
							//EJERCICIO 3)4)
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2,
													int tanqueAuto){
		
		List<String> resultado = new LinkedList<String>();
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			boolean marca [] = new boolean[mapaCiudades.getSize()];
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			
			if(origen != null && destino != null) {
				buscarCaminoSinCargar(origen, destino, resultado, marca,tanqueAuto);
			}
		}
		
		return resultado;
	}
	
	private boolean buscarCaminoSinCargar(Vertex<String> origen, Vertex<String>destino,
										List<String>resultado,boolean marca[],int tanque) {
		
		boolean encontre = false;
		marca[origen.getPosition()] = true;
		resultado.add(origen.getData());
		
		if(origen == destino) {
			return true;
		}else {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> iterador = adyacentes.iterator();
			while(!encontre && iterador.hasNext()) {
				Edge<String> e = iterador.next();
				int nuevoTanque = tanque - e.getWeight();
				int pos = e.getTarget().getPosition();
				if(!marca[pos] && nuevoTanque >= 0) {
					encontre = buscarCaminoSinCargar(e.getTarget(), destino, 
													resultado, marca, nuevoTanque);
				}
			}
		}
		
		if(!encontre) {
			resultado.remove(resultado.size()-1);
		}
		
		marca[origen.getPosition()] = false;
		return encontre;
	}
	
	
					//EJERCICIO 3)5)
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2,
														int tanqueAuto){
		
		List<String> camino = new LinkedList<String>();
		if(mapaCiudades != null && !mapaCiudades.isEmpty()) {
			boolean marca [] = new boolean[mapaCiudades.getSize()];
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			
			if(origen!= null && destino != null) {
				buscarCam(origen, destino, camino, marca,tanqueAuto,tanqueAuto,
					Integer.MAX_VALUE,0,new LinkedList<String>());
			}
		}
		
		return camino;
	}
	
	
	private int buscarCam(Vertex<String>origen,Vertex<String>destino,
						List<String>resultado,boolean marca[],int tanqueAct,
						int tanqueOriginal,int min,int cant,List<String>caminoActual){
		
		
		marca[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		
		
		if(origen == destino &&  cant < min) {
			min = cant;
			resultado.clear();
			resultado.addAll(caminoActual);
		}else {
			List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> iterador = adyacentes.iterator();
			while(iterador.hasNext() && cant < min) {
				Edge<String> e = iterador.next();
				Vertex<String> v = e.getTarget();
				int pos = v.getPosition();
				if(!marca[pos]) {
					tanqueAct =  tanqueAct - e.getWeight();
					if(tanqueAct  < 0) {
						tanqueAct  = tanqueOriginal;
						cant++;
					}
				}
				min = buscarCam(v, destino, resultado, marca, tanqueAct, tanqueOriginal, min, cant, caminoActual);
				}
			}
		
		marca[origen.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
		return min;
		
	}
	
	
}
