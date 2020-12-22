package edu.epidata.tp1.comparator;

import java.util.Comparator;

import edu.epidata.tp1.enfrentable.Enfrentable;

public class ComparatorNombre implements Comparator<Enfrentable>{
	
	

	/*
	 * Uso compareTo que nos dice quien es mayor lexicograficamente.
	 * Devuelve:
	 * <0 entonces e1.getnombre es primero lexicograficamente.
	 * ==0 entonces son equivalentes.
	 * >0 entonces e2.getnombre es primero lexicograficamente.
	 */
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		
		return e1.getNombre().compareTo(e2.getNombre());
	}

}
