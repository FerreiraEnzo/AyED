package Resoluciones.Practica1.Ejercicio8;

public class DoubleEndedQueue<T> extends Queue<T> {
	
	public void enqueueFirst(T elem) {
		this.data.add(0,elem);	//AGREGO AL FINAL DE LA COLA, EN EL RABO DE LA COLA
	}

}
