package RepasoGrafos;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class RecorridosV2<T> {
	
	
	public List<T> dfs(Graph<T> grafo){
		
		List<T> lista = new LinkedList<T>();
		
		if(grafo != null && !grafo.isEmpty()) {
			boolean marca [] = new boolean[grafo.getSize()];
			for (int i = 0; i<grafo.getSize(); i++) {
				if(!marca[i]) {
					dfs(i,grafo,lista,marca);
				}
			}
		}
		return lista;
	}
	
	private void dfs(int i, Graph<T>grafo,List<T>lista,boolean marca[]) {
		
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		lista.add(v.getData());
		
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for(Edge<T> a : adyacentes) {
			int pos = a.getTarget().getPosition();
			if(!marca[pos])
				dfs(pos,grafo,lista,marca);
		}
	}
	
	public List<T> bfs(Graph<T>grafo){
		
		List<T> resultado = new LinkedList<T>();
		if(grafo != null && !grafo.isEmpty()) {
			boolean marca [] = new boolean[grafo.getSize()];
			for(int i = 0; i<grafo.getSize(); i++) {
				if(!marca[i])
					bfs(i,grafo,resultado,marca);
			}
		}
		
		return resultado;
		
		
	}
	
	private void bfs(int i,Graph<T>grafo,List<T>resultado,boolean marca []) {
		
		Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
		cola.enqueue(grafo.getVertex(i));
		marca[i] = true;
		
		while(!cola.isEmpty()) {
			Vertex<T> w = cola.dequeue();
			resultado.add(w.getData());
			List<Edge<T>> adyacentes = grafo.getEdges(w);
			for(Edge<T> e : adyacentes) {
				int j = e.getTarget().getPosition();
				Vertex<T> v = e.getTarget();
				if(!marca[j]) {
					marca[j] = true; 
					cola.enqueue(v);
				}
			}
		}
	}
	
}
