package edu.epidata;

public class Reporte1Query {
	
	private int personaId;
	private long cant;
	
	public Reporte1Query(int personaId, long cant) {
		super();
		this.personaId = personaId;
		this.cant = cant;
		
	
	}
	//Getters y Setters
	
	@Override
	public String toString() {
	return "Reporte1Query [IDpersona=" + personaId +
	", Cantidad de Libros Editados=" + cant + "]";
	}

}
