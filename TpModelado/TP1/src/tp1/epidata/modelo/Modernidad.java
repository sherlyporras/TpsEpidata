package tp1.epidata.modelo;

import java.util.Map;



public class Modernidad implements ICaracteristicasExtras {
	
	public Modernidad() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cargarExtras(Map<String, Integer> mapcaract) {
		// TODO Auto-generated method stub
	try {
		int tecno=mapcaract.get("Tecnologia");
		int supoder=mapcaract.get("Superpoderes");
	    if (tecno>supoder)
			mapcaract.put("Modernidad",mapcaract.get("Edad"));
		else
			mapcaract.put("Modernidad",10);
		}catch (NullPointerException e) {
		 System.out.println("Error cargar modernidad, no existe caracteristicas");
			
		}
		
		
	}

	
	
	

}
