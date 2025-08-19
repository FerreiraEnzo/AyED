package Resoluciones.Practica1.Ejercicio7;

import java.util.LinkedList;

public class PuntoI {
	
	public static int calcularSuma(LinkedList<Integer> listaSuma) {
		return calcularSumaRec(listaSuma,listaSuma.size()-1);
		
	}
	
	private static int calcularSumaRec(LinkedList<Integer>listaSuma,int indice) {
		if(indice < 0) { //LISTA VACIA O LLEGUE AL FINAL, ESTOY RECORRIENDO DE ATRAS PARA ADELANTE
			return 0;
		}else {
			return listaSuma.get(indice) + calcularSumaRec(listaSuma, indice - 1); 
		}
	}
}
