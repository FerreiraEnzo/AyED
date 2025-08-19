package Resoluciones.Practica1.Ejercicio2;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
			for(int i=0; i<3; i++) {
			System.out.println("Ingrese un numero: ");
			int num = scanner.nextInt();
			int [] nuevoArreglo = StaticClass.generar(num);
			for(int j =0; j<num ; j++) {
				System.out.println(nuevoArreglo[j]);
			System.out.println("\n");
		}
		}
	}
}


	


