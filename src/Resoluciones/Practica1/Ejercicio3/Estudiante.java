package Resoluciones.Practica1.Ejercicio3;

public class Estudiante extends Persona {
	private int comision;
	private int direccion;
	
	public Estudiante(String name,String ape,String email,int comi,int dir) {
		super(name, ape, email);
		this.setComision(comi);
		this.setDireccion(dir);
	}
	
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	

	public String toString() {
		String aux = "";
		aux+= super.toString() + "Comision: " + this.getComision() + "Direccion: " + 
		this.getDireccion();
		return aux;
		
	}
	
	
}
