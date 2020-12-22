package edu.epidata.tp1.comparator;

import java.util.Comparator;

import edu.epidata.tp1.enfrentable.Enfrentable;

public class ComparatorCriterioSimple implements Comparator<Enfrentable>{
	
	private String atributo;
	public ComparatorCriterioSimple(String atributo) {
		this.atributo=atributo;
	}
	
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		Float valorAtE1=e1.getValorAtributo(atributo);
		Float valorAtE2=e2.getValorAtributo(atributo);
		return valorAtE1.compareTo(valorAtE2);
	}

}
