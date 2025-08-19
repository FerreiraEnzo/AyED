package Resoluciones.Practica1.Ejercicio7;

import java.util.LinkedList;
import java.util.List;

public class PuntoG {
	
	
	public static List<Integer> calcularSucesion(int unNum) {
		List<Integer> listaSucesion = new LinkedList<Integer>();
		calcularSucesionRec(listaSucesion,unNum);
		return listaSucesion;
		}
	
		
	private static  void calcularSucesionRec(List<Integer> listaSucesion, int num) {
		listaSucesion.add(num);
		if(num>1) 	//CASO BASE
			if(num % 2 ==0) {
				calcularSucesionRec(listaSucesion, num/2);
			}else {
				calcularSucesionRec(listaSucesion, num *3 + 1);
			}	
		}
	}
	
	
	


