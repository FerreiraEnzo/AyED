package Resoluciones.Practica1.Ejercicio8;

import java.util.List;
import java.util.LinkedList;

public class Queue <T> extends Sequence {
	LinkedList <T> data;
	
	public Queue() {
		this.data = new LinkedList<T>();
	}
	
	public void enqueue(T dato) {
		data.add(dato);	
	}
		
	public T dequeue() {
		return data.remove(0);
	}
	
	public T head() {
		return data.get(0);
	}
	
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public int size() {
		return data.size();
	}
	
	public String toString() {
		String aux = "[";
		for(T d: data) 
			aux = aux + d + " , ";
		aux = aux.substring(0, aux.length()-2)+"]";
		return aux;
		}
	}
	
		


