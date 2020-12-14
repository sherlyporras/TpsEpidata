package tp1.epidata.modelo;

import java.util.ArrayList;
import java.util.List;

public class Liga {
	private List<Personaje> listRestantes=new ArrayList<Personaje>();
	
	public Liga() {
		
	}
	public List<Personaje> generarLigaHeroe(List<Personaje> listaGeneral){
		List<Personaje> aux=new ArrayList<Personaje>();
		
		for (Personaje personaje : listaGeneral) {
			if (personaje.esHeroe()) {
				aux.add(personaje);				
			}else {
				this.listRestantes.add(personaje);
			}
		}
		return aux;
		
	}
	public List<Personaje> generarLigaVillano(List<Personaje> listaGeneral){
		List<Personaje> aux=new ArrayList<Personaje>();
		
		for (Personaje personaje : listaGeneral) {
			if (personaje.esVillano()) {
				aux.add(personaje);				
			}else {
				this.listRestantes.add(personaje);
			}
		}
		return aux;
		
	}
	public List<Personaje> restantes() {
		return listRestantes;
		
		
	}
}
