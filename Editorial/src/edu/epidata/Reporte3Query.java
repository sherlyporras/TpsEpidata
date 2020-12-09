package edu.epidata;

public class Reporte3Query {
	private int personaId;
	private long cant;
	
	public Reporte3Query(int personaId, long cant) {
		super();
		this.personaId = personaId;
		this.cant = cant;
		
	
	}
	//Getters y Setters
	
	@Override
	public String toString() {
	return "Reporte3Query [IDpersona=" + personaId +
	", Cantidad de Libros, como autor de capitulo=" + cant + "]";
	}

}
