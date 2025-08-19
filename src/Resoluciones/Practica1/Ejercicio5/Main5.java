package Resoluciones.Practica1.Ejercicio5;

public class Main5 {

	public static void main(String[] args) {
		int [] vec = new int [5];
		
		for(int i=0; i<vec.length;i++) {
			vec[i]=i*3;
		}
			
		
		Datos d1=Calculos.calcular1(vec);
		System.out.println("INCISO 1: "); 
		System.out.println(d1.toString());
		System.out.println();
		
		
		
		Datos d2 = new Datos();
		Calculos.calcular2(vec,d2);
		System.out.println("INCISO 2: ");
		System.out.println(d2.toString());
		System.out.println();
		
		
		Calculos.imprimir(vec);
		
		//
		//
		
	}

}
