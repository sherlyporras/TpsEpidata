package edu.epidata.tp1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import java.util.stream.Collectors;

import edu.epidata.tp1.enfrentable.Enfrentable;
import edu.epidata.tp1.enfrentable.Personaje;

public class Juego {
	List<Enfrentable> enfrentables;
	
	
	public Juego() {
		this.enfrentables=new LinkedList<Enfrentable>();
	}
	public List<Enfrentable> getQuienesVencen(Enfrentable e, Comparator<Enfrentable> c){
		List<Enfrentable> auxvencen=enfrentables.stream()
												.filter(fe -> c.compare(e, fe)<0)
												.collect(Collectors.toList());
		
		
		return auxvencen;
		
	}
	public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) {
		return e1.enfrentar(e2, c);
		
	}
	
	
	public Boolean addEnfrentable(Enfrentable e) {
		
		
		
		return enfrentables.add(e);
		
	}
	
	public List<Personaje> ordenarPersonjes(Comparator<Enfrentable> c){
		List<Personaje> personAux = enfrentables.stream()
												.map(fe-> fe.ordenar(c))
												.flatMap(List::stream)
												.distinct()
												.sorted(c)
												.collect(Collectors.toList());
		
		
		return personAux;
		
	}

}
