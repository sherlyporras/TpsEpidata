package edu.epidata.tp1.atributo;

import edu.epidata.tp1.enfrentable.Enfrentable;

public class AtributoSimple implements Atributo {
	
	private float value;
	
	public AtributoSimple(float value) {
		this.value=value;
		
	}
	
	public void setValor(float value) {
		this.value=value;
		
	}

	

	@Override
	public float getValor(Enfrentable e) {
		
		return value;
	}
	

}
