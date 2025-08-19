package Resoluciones.Practica1.Ejercicio3;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String email;
	
	public Persona(String name,String ape,String email) {
		this.setNombre(name);
		this.setApellido(ape);
		this.setEmail(email);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		String aux = "";
		aux+= "Nombre: " + this.getNombre() + "Apellido: " + this.getApellido() +
				"Email: " + this.getEmail() +  this.toString();
		return aux;
	}
	
	
	
	
}
