package Resoluciones.Practica1.Ejercicio1;


public class ProbandoEj1 {
	
public static void sumaFor(int a, int b) {
	for(int i=a; i<=b; i++)
		System.out.println(i + "\n");
}
public static void suma2(int a, int b) {
	while(a <= b) {
		System.out.println(a + "\n" );
		a++;
	}
}

public static void suma3(int a,int b) {
	if(a <= b) {
		System.out.println(a + "\n");
		suma3(++a, b);
	}
	
	
	
}
	
}


