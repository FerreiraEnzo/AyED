package Resoluciones.Practica1.Ejercicio2;


public class StaticClass {
	
public static int [] generar (int N) {
	
	int [] vector = new int [N];
	
	for(int i=0; i<N; i++) {
		vector[i] = N *(i+1); 
	}
	
	return vector; 	
}
	
}
