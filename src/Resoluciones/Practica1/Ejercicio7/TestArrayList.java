package Resoluciones.Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
	
	
	public static void armarLista(int [] vec) {
		
		List <Integer> lista = new ArrayList<>();
		
		for(int i=0; i<vec.length;i++) {
			lista.add(vec[i]);			
		}
		
		for(int elem: lista) {
			System.out.println("Elemento: " + elem);
		}
		
		List <Integer> numeros = new LinkedList<>();
		for(int i=0;i<vec.length;i++) {
			numeros.add(vec[i]);
		}
		
		System.out.println("Imprimiendo LinkedList");
		for(int elem: lista) {
			System.out.println("Item: " + elem);
		}
		
		// INCISO 7.C SE PUEDE RECORRER LAS LISTAS CON FOR TRADICIONAL O FOR EACH
	}
	
		public static void operar() {
		List <Estudiante> estudiantes= new LinkedList<>();
		estudiantes.add(new Estudiante("Marcos",29,112233));
		estudiantes.add(new Estudiante("Pablo", 20, 334455));
		estudiantes.add(new Estudiante("Carla", 21, 556677));
		LinkedList <Estudiante> lista_copiada = new LinkedList<Estudiante>(estudiantes);
		
		
		estudiantes.get(0).setNombre("LOPEZ");
		System.out.println("LISTA ORIGINAL: ");
			for(Estudiante e: estudiantes) {
				System.out.println(e.toString());
				System.out.println();
			}
		
		System.out.println("LISTA COPIADA: ");	
			for(Estudiante x: lista_copiada) {
				System.out.println(x.toString());
				System.out.println();
			}
		//AL MODIFICAR UNA LISTA, SE MODIFICAN LAS DOS
		
			
		//INCISO E
		Estudiante e1= new Estudiante("Carlos", 32, 667788);
		boolean estaba = false;
		for(Estudiante n: estudiantes) {
			estaba=(n.comparar(e1));
			if(estaba) {
				System.out.println("El estudiante ya se encontraba en la lista");
				break;
			}
		}
		if(!estaba)
			estudiantes.add(e1);
			
		
		
		System.out.println("PROBANDO");	
		for(Estudiante m: estudiantes) {
			System.out.println(m.toString());
		}
		
		
		
}
}
