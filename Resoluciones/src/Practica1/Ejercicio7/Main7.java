package Resoluciones.Practica1.Ejercicio7;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int [] vector = new int[5];
				
		for(int i=0;i<vector.length;i++) {
			System.out.println("Ingrese un numero: ");
			int num = scanner.nextInt();
			vector[i] = num; 
		}
		
		TestArrayList.armarLista(vector);
		
		
		TestArrayList.operar();

		ArrayList <Integer> miLista = new ArrayList<Integer>();
		for(int i=0;i<3;i++) {
			miLista.add(i*2);
		}
		
		PuntoF.esCapicua(miLista);
		
		System.out.println("Ingrese un numero para la sucesion: ");
		int numero = scanner.nextInt();
		List<Integer> listaSucesion = PuntoG.calcularSucesion(numero);
		System.out.println();
		System.out.println("SUCESION: ");
		for(int x: listaSucesion) {
			System.out.println(x);
		}
		
		System.out.println();
		System.out.println("INCISO H: ");
		ArrayList<Integer> listaInvertida = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			System.out.println("Ingrese un numero para la lista: ");
			int j = scanner.nextInt();
			listaInvertida.add(j);
		}
		System.out.println("LISTA EN ORDEN NORMAL: ");
		for(int k: listaInvertida) {
			System.out.println(k);
		}
		PuntoH.invertirArrayList(listaInvertida);
		System.out.println();
		System.out.println("LISTA EN ORDEN INVERTIDO: ");
		for(int k: listaInvertida) {
			System.out.println(k);
		}
		System.out.println();
		System.out.println("INCISO I");
		LinkedList<Integer> listaSuma = new LinkedList<Integer>();
		listaSuma.add(5);
		listaSuma.add(10);
		listaSuma.add(20);
		System.out.println("Suma total de los elementos de la lista: " 
							+  PuntoI.calcularSuma(listaSuma));
		
		//INCISO J
		System.out.println();
		System.out.println("INCISO J: ");
		ArrayList<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9));
		ArrayList<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(2,4,6,8,10));
		
		ArrayList<Integer> listaResultado = PuntoJ.combinarOrdenado(lista1,lista2);
		System.out.println("Lista combinada y ordenada: " + listaResultado);
	}

}
