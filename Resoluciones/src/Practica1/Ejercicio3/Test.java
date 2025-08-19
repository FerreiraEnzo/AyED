package Resoluciones.Practica1.Ejercicio3;

public class Test {

	public static void main(String[] args) {
		Estudiante [] arreglo = new Estudiante[2];
		Profesor [] vector = new Profesor[3];
		
		Estudiante e1 = new Estudiante("Carlos","Perez","asdasdd.com",1,866);
		Estudiante e2 = new Estudiante("Mario", "Kempes","dsajads.com", 4, 799);
		arreglo[0]=e1;
		arreglo[1]=e2;
		
		Profesor p1 = new Profesor("Alberto", "Lopez", "asddas.com", "Matematica", "UNLP");
		Profesor p2 = new Profesor("Maria", "Fernandez", "sdasad.com","Biologia", "UCALP");
		
		vector[0]=p1;
		vector[1]=p2;
		
		for(int i=0; i<arreglo.length;i++) {
			System.out.println(arreglo[i].toString());
			System.out.println("\n");
		}
		for(int j=0; j<vector.length;j++) {
			System.out.println(vector[j].toString());
			System.out.println("\n");
		}
			
			
			
		}
		
		
		
		
		
		
	}


