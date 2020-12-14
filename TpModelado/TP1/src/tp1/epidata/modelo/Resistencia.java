package tp1.epidata.modelo;

import java.util.Map;

public class Resistencia implements ICaracteristicasExtras{
	
	public Resistencia() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cargarExtras(Map<String, Integer> mapcaract) {
		// TODO Auto-generated method stub
		try {
			int fuerza=mapcaract.get("Fuerza");
			int velocidad=mapcaract.get("Velocidad");
			int result=(int)fuerza/velocidad; 
			
			mapcaract.put("Resistencia",result );
		} catch (NullPointerException e) {
			System.out.println("Error cargar Resistencia, no existe caracteristicas.");
			
		}
		
	}

	


	
	

}
