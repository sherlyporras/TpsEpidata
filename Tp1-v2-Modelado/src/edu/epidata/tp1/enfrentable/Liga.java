package edu.epidata.tp1.enfrentable;

import java.util.LinkedList;
import java.util.List;

public class Liga extends Enfrentable {
	
	private List<Enfrentable> integrantes;
	
	
	public Liga(String nombre, String nomfantasia,List<Enfrentable> integrantes) {
		this.nombre=nombre;
		this.nombreFantasia=nomfantasia;
		this.integrantes=new LinkedList<Enfrentable>();
		this.integrantes.addAll(integrantes);
	}
	public Liga(String nombre, String nomfantasia) {
		this.nombre=nombre;
		this.nombreFantasia=nomfantasia;
		this.integrantes=new LinkedList<Enfrentable>();
	}
	
	public Boolean addIntegrante(Enfrentable e) {
		try {
			
			return integrantes.add(e);
		} catch (Exception e2) {
			return false;
		}	
		
	}

	/*
	 *getValorAtributo de una liga es el promedio de los mismos 
	 */
	@Override
	public float getValorAtributo(String nombreAtributo) {
		
		int cantpersonajes=integrantes.size();
		float sum=0;
		 
		for (Enfrentable enfrentable : integrantes) {
			sum=sum+enfrentable.getValorAtributo(nombreAtributo);
		}
		
		return (float)sum/cantpersonajes;
	}

	@Override
	protected List<Personaje> getPersonajes() {
		List<Personaje> auxpersonaje=new LinkedList<Personaje>();
		for (Enfrentable enfrentable : integrantes) {
			auxpersonaje.addAll(enfrentable.getPersonajes());			
		}
		return auxpersonaje;
	}
	

}
