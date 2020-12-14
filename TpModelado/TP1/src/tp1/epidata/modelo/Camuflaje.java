package tp1.epidata.modelo;

import java.util.Map;

public class Camuflaje implements ICaracteristicasExtras {
	
	public Camuflaje() {
		
	}

	@Override
	public void cargarExtras(Map<String, Integer> mapcaract) {
		
		try {
			int invisi=mapcaract.get("Invisibilidad");
			int fuerza=mapcaract.get("Fuerza");
			
			if (invisi>fuerza)
				mapcaract.put("Camuflaje",50);
			else
				mapcaract.put("Camuflaje", mapcaract.get("Velocidad"));
			
		} catch (NullPointerException e) {
			System.out.println("Error cargar Camuflaje, no existe caracteristica.");
		}
		
	}

	

}
