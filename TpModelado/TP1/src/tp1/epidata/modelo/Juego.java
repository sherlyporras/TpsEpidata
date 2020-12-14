package tp1.epidata.modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	private List<Personaje>listPersonaje=new ArrayList<Personaje>();
	
	
	
	private List<Personaje>ligaHeroes=new ArrayList<Personaje>();
	
	private List<Personaje>ligaVillanos=new ArrayList<Personaje>();
	
	private List<Personaje>personajesRestante=new ArrayList<Personaje>();
	
	private Liga liga=new Liga();
	private Comparar comparar =new Comparar();
	
	public Juego() {
		
	}
	
	
	public void cargarPersonaje(Personaje inputPersonaje) {
		this.listPersonaje.add(inputPersonaje);	
		
	}
	public int cantidadPersonaje() {		
		return listPersonaje.size();		
	}
	public void formarLigaHeroes() {
		this.ligaHeroes=liga.generarLigaHeroe(listPersonaje);
		this.personajesRestante=liga.restantes();
		
	}
	public void formarLigaVillano() {
		ligaVillanos=liga.generarLigaVillano(listPersonaje);
		personajesRestante=liga.restantes();
	}
	public void cargarCriterios(String criterio) {
		
		comparar.setCriterio(criterio);
		
	}
	public int getCantidadHeroes() {
		return ligaHeroes.size();
		
	}
	public int getCantidadVillano() {
		return ligaVillanos.size();
	}
	public void generarResultado() {
		
		if (getCantidadHeroes()>0) {
			comparar.compararCriterio(this.ligaHeroes, this.personajesRestante);	
			
			
		}else if (getCantidadVillano()>0) {
			comparar.compararCriterio(this.ligaVillanos, this.personajesRestante);
			
			
		}else {
			
			comparar.compararCriterio(listPersonaje);
		}	
		
		
		
		comparar.publicarResultado();	
		
		
		
	}

	

}
