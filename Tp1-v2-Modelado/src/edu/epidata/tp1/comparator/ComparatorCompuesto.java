package edu.epidata.tp1.comparator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import edu.epidata.tp1.enfrentable.Enfrentable;

public class ComparatorCompuesto implements Comparator<Enfrentable>{
	
	private List<Comparator<Enfrentable>> comparators;
	
	public ComparatorCompuesto() {
		this.comparators=new LinkedList<Comparator<Enfrentable>>();
	}
	public ComparatorCompuesto(List<Comparator<Enfrentable>> comparators) {
		this.comparators=comparators;
	}
	public boolean addComparators(Comparator<Enfrentable> c) {
		if(c==this) 
			return false;
		return comparators.add(c);
	}
	public boolean addComparators(Comparator<Enfrentable> c, int indice) {
		if(c==this) 
			return false;
		comparators.add(indice, c);
		return true;
		
	}
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		int resul;
		for (Comparator<Enfrentable> comparator : comparators) {
			resul=comparator.compare(e1, e2);
			if (resul!=0) 
				return resul;
		}
		return 0;
	}

}
