package Resoluciones.Practica1.Ejercicio5;

public class Calculos {
	
	public static Datos calcular1(int [] vector) {
		int cantidad = vector.length;
		int total = 0, max=-1, min=9999;
		
		for(int i=0; i<vector.length;i++) {
			total+=vector[i];
			if(vector[i]>max) 
				max=vector[i];
			if(vector[i]<min)
				min = vector[i];
		}
		
		Datos obj = new Datos();
		double promedio = total/cantidad;
		obj.setMax(max);
		obj.setMin(min);
		obj.setPromedio(promedio);
		return obj;
		
	}
	
	public static void calcular2(int [] vector, Datos unObjeto) {
		int total = 0, max=-1, min=9999;
		
		for(int i=0; i<vector.length;i++) {
			total+=vector[i];
			if(vector[i]>max) 
				max=vector[i];
			if(vector[i]<min)
				min = vector[i];
		}
		
		int cantidad = vector.length;
		double promedio = total/cantidad;
		unObjeto.setMax(max);
		unObjeto.setMin(min);
		unObjeto.setPromedio(promedio);	
	}
	
	public static void imprimir(int [] vector) {
		int total = 0, max=-1, min=9999;
		
		for(int i=0; i<vector.length;i++) {
			total+=vector[i];
			if(vector[i]>max)
				max=vector[i];
			if(vector[i]<min)
				min=vector[i];
		}
			
		int cant = vector.length;
		double promedio = total/cant;
		System.out.println("INCISO 3");
		System.out.println("El maximo es: " + max + "El minimo es: " + min + "El promedio es: " + promedio);
					
		}
		
		
	}
	



