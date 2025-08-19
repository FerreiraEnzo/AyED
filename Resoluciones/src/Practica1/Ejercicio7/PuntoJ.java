package Resoluciones.Practica1.Ejercicio7;

import java.util.ArrayList;

public class PuntoJ {
	
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer>lista2){
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		
		while(!lista1.isEmpty() && lista2.isEmpty()) {
			if(lista1.get(0) < lista2.get(0)) {
				resultado.add(lista1.remove(0));
			}else {
				resultado.add(lista2.remove(0));
			}
		}
		
		if(lista1.isEmpty()) {
			resultado.addAll(lista2);
		}else {
			resultado.addAll(lista2);
		}
		
		return resultado;
	}
	
	

}
