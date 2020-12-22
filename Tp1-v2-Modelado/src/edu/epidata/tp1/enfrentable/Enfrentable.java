package edu.epidata.tp1.enfrentable;

import java.util.Comparator;
import java.util.List;

public abstract class Enfrentable {
	
	protected String nombre;
	protected String nombreFantasia;
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getNombreFantasia(){
		return this.nombreFantasia;
		
	}
	
	public abstract float getValorAtributo(String a);
	
	
	public Enfrentable enfrentar(Enfrentable rival, Comparator<Enfrentable> c) {
		
		int resul=c.compare(this,rival);
		if (resul==0) 
			return null;
		
		return resul>0?this:rival;
		
	}
	
	public List<Personaje> ordenar(Comparator<Enfrentable> c) {
		
		List<Personaje> auxOrdenadas=getPersonajes();
		auxOrdenadas.sort(c);
		
		return auxOrdenadas;
		
	}
	
	protected abstract List<Personaje> getPersonajes();

}
