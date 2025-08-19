package Resoluciones.Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class PuntoF {
	
	public static boolean esCapicua(ArrayList<Integer> miLista) {
		boolean es = true;
		
		int [] vec1 = new int [] {2,5,2};
		int[] vec2 = new int [] {4,5,6,3,4};
		
		if(!miLista.isEmpty()){
			int inicio = 0;
			int fin = miLista.size() -1;
			while(inicio<fin && es) {
				if(miLista.get(inicio).equals(miLista.get(fin))) {
					inicio++;
					fin--;
				}
				else {
					es = false;
				}	
			}
		}
		return es;
	}
			
			
		}
				
			
			
		
	
		
		
		
	
	
	


