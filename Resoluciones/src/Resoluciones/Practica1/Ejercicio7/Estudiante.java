package Resoluciones.Practica1.Ejercicio7;


public class Estudiante {
	private String nombre;
	private int edad;
	private int legajo;
	
	public Estudiante(String name, int unaEdad, int unLegajo) {
		this.setNombre(name);
		this.setEdad(unaEdad);
		this.setLegajo(unLegajo);
	}
	
	
	public String toString() {
		String aux = "";
		aux+= "Nombre: " + this.getNombre() + "Edad: " + this.getEdad() + "Legajo: " +
				this.getLegajo();
 		return aux;
	}	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public boolean comparar(Estudiante unEstudiante) {
		boolean ok = false;
		if(unEstudiante.getNombre() == this.getNombre() && unEstudiante.getEdad()==
				this.getEdad() && unEstudiante.getLegajo() == this.getLegajo()) {
			ok = true;
		}
		return ok;
	}
	
	
	
}
