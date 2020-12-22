package edu.epidata.tp1.atributo;

import edu.epidata.tp1.enfrentable.Enfrentable;

public class OperacionDivisionAtributos extends AtributoOperacion{

	public OperacionDivisionAtributos(String key1, String key2) {
		super(key1, key2);
		
	}

	@Override
	public float getValor(Enfrentable e) {
		try {
			
			return e.getValorAtributo(key1)/e.getValorAtributo(key2);
		} catch (ArithmeticException e2) {
			
			return -1;
		}
		
	}

	

}
