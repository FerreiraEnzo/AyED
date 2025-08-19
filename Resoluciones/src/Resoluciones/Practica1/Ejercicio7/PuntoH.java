package Resoluciones.Practica1.Ejercicio7;

import java.util.ArrayList;

public class PuntoH {
	
	public static void invertirArrayList(ArrayList<Integer>listaInvertida) {
			invertirRec(listaInvertida,0,listaInvertida.size()-1);
	}

	private static void invertirRec(ArrayList<Integer>listaInvertida,int ini,int fin) {
		if(ini<fin) {
			int temp = listaInvertida.get(ini);
			listaInvertida.set(ini, listaInvertida.get(fin));
			listaInvertida.set(fin, temp);
			invertirRec(listaInvertida,ini + 1, fin -1);
		}
	}
	

}