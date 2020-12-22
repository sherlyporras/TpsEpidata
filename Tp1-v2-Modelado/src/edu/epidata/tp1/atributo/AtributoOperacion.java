package edu.epidata.tp1.atributo;

import edu.epidata.tp1.enfrentable.Enfrentable;

public abstract class AtributoOperacion implements Atributo {
	protected String key1;
	protected String key2;
	
	public AtributoOperacion(String k1,String k2) {
		this.key1=k1;
		this.key2=k2;
		
	}
	

	@Override
	public abstract float getValor(Enfrentable e);

}
