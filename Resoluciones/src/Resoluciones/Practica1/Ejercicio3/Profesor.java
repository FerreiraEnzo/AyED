package Resoluciones.Practica1.Ejercicio3;

public class Profesor extends Persona{
	private String catedra;
	private String facultad;
	
	public Profesor(String name,String ape,String email,String cate,String facu) {
		super(name, ape, email);
		this.setCatedra(cate);
		this.setFacultad(facu);
	}
	
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}



	public String toString() {
		String aux = "";
		aux+= super.toString() + "Catedra; " + this.getCatedra() + 
				"Facultad: " + this.getFacultad();
		return aux;
	}
	
	
	
}
