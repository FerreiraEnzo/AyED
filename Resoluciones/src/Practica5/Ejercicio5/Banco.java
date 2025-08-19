package TP5Ejercicio5V2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Banco {
	
	
	public List<Vertex<Persona>> quedateEnCasa(Graph<Persona>grafo,Persona empleado,int distancia){
		
		List<Vertex<Persona>> lista = new LinkedList<Vertex<Persona>>();
		if(grafo != null && !grafo.isEmpty()) {
			boolean marca [] = new boolean[grafo.getSize()];
			Vertex<Persona> origen = buscarEmpleado(grafo,empleado);
			int nivel = 0;
			int max = 40;
			
			if(origen != null) {
				marca[origen.getPosition()] = true;
				Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
				cola.enqueue(origen);
				cola.enqueue(null);
				
				while(!cola.isEmpty() && lista.size() < max && nivel <= distancia) {
					Vertex<Persona> aux = cola.dequeue();
					if(aux != null) {
						if(aux.getData().getTipo().equals("Jubilado"))
							lista.add(aux);
						List<Edge<Persona>> adyacentes = grafo.getEdges(aux);
						Iterator<Edge<Persona>> iterador = adyacentes.iterator();
						while(iterador.hasNext() && lista.size() < max) {
							Edge<Persona> e = iterador.next();
							int pos = e.getTarget().getPosition();
							if(!marca[pos] && lista.size() < max) {
								marca[pos] = true;
								cola.enqueue(e.getTarget());
							}
						}
					}else {
						if(!cola.isEmpty()) {
							cola.enqueue(null);
							nivel++;
						}
					}
				}
			}
		}
		
		return lista;
	}
	
	
	private Vertex<Persona> buscarEmpleado(Graph<Persona>grafo,Persona empleado){
		
		Vertex<Persona> emp = null;
		boolean encontre = false;
		List<Vertex<Persona>> vertices = grafo.getVertices();
		Iterator<Vertex<Persona>> iterador = vertices.iterator();
		while(!encontre && iterador.hasNext()) {
			Vertex<Persona> w = iterador.next();
			if(w.getData().getTipo().equals(empleado.getTipo()) 
				&& w.getData().getName().equals(empleado.getName())){
				emp = w;
				encontre = true;
			}
		}
		
		return emp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
