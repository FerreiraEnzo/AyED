package Resoluciones.Practica1.Ejercicio8;

public class CircularQueue<T> extends Queue<T> {
	
	public T shift() {
		T element = dequeue(); //EXTRAIGO Y ELIMINO EL ULTIMO ELEMENTO DE LA COLA
		enqueue(element);	//CONSULTAR
		return element;
	}
	
}

