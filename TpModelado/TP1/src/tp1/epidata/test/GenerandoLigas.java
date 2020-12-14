package tp1.epidata.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import tp1.epidata.modelo.Juego;
import tp1.epidata.modelo.Personaje;


public class GenerandoLigas {
	
	private Personaje heroe1; 
	private Personaje heroe2;
	private Personaje heroe3;
	
    private Personaje villano1;
    
    private Juego juego;
	
	
	/*
	 * *
	 * Debemos de cargar las caracteristicas de los personajes.
	 * */
	@BeforeEach
	public void setUp() {
		heroe1=new Personaje("jugador1", "superman", true, false);
		heroe2=new Personaje("jugador1", "spiderman", true, false);
		heroe3=new Personaje("jugador1", "batman", true, false);
		
		villano1=new Personaje("jugador2", "thanos", false, true);
		
		juego=new Juego();
		
		
	}	
	@Test
	public void testGenerarLigaDeSuperHeroesAPartirDeLosYaCargados() {
		juego.cargarPersonaje(heroe1);
		juego.cargarPersonaje(heroe2);
		juego.cargarPersonaje(heroe3);
		juego.cargarPersonaje(villano1);

		
		juego.formarLigaHeroes();
		
		
		juego.formarLigaVillano();
		
		assertEquals(juego.getCantidadVillano(),1);
		assertEquals(juego.getCantidadHeroes(), 3);
				
	}
	
	

}
