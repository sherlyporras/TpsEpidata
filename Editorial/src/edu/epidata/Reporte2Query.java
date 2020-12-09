package edu.epidata;

public class Reporte2Query {
	
	private int personaId;
	private long cant;
	
	public  Reporte2Query (int personaId, long cant) {
		super();
		this.personaId = personaId;
		this.cant = cant;
		
	
	}
	//Getters y Setters
	
	@Override
	public String toString() {
	return "Reporte2Query [IDpersona=" + personaId +
	", Cantidad de Paginas revisadas=" + cant + "]";
	}

}
