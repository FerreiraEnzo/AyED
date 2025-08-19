package RepasoGrafos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.AdjListGraph;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio6.Buscador;

public class Ejercicio6 {
	private Graph<String> bosque;

	
	public void setBosque(Graph<String> bosque) {
		this.bosque = bosque;
	}
	
	public Graph<String> getBosque() {
		return bosque;
	}

	
	public List<List<String>> recorridosMasSeguro(){
		
		List<List<String>> lista = new LinkedList<>();
		if(bosque != null && !bosque.isEmpty()) {
			boolean marca [] = new boolean[bosque.getSize()];
			Vertex<String> origen = bosque.search("Casa Caperucita");
			Vertex<String> destino = bosque.search("Casa abuelita");
			
			if(origen != null && destino != null) {
				dfs(origen,destino,lista,marca,new LinkedList<String>());
			}
		}
		
		return lista;
	}
							// TODOS LOS CAMINOS
			
	private void dfs(Vertex<String>origen,Vertex<String>destino,List<List<String>>lista,
					boolean marca[],List<String>caminoActual) {
		
		
		marca[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		
		if(origen == destino) {
			lista.add(new LinkedList<>(caminoActual));
		}else {
			List<Edge<String>> adyacentes = bosque.getEdges(origen);
			Iterator<Edge<String>> iterador = adyacentes.iterator();
			while(iterador.hasNext()) {
				Edge<String> e = iterador.next();
				Vertex<String> w = e.getTarget();
				int pos = w.getPosition();
				if(!marca[pos] && e.getWeight() <= 5) {
					dfs(w, destino, lista, marca, caminoActual);
				}
			}
		}
			
		marca[origen.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
	}
	
	
	public static void main (String[] args) {
		
		
        Graph<String> bosque = new AdjListGraph<String>();
        
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        Buscador bos = new Buscador(bosque);
        List<List<String>> lis = bos.recorridosMasSeguros();
        for(List<String> l: lis)
            System.out.println(l);
	}


}
