package tp1.epidata.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp1.epidata.modelo.Camuflaje;
import tp1.epidata.modelo.Juego;
import tp1.epidata.modelo.Modernidad;
import tp1.epidata.modelo.Personaje;
import tp1.epidata.modelo.Resistencia;

public class Jugar {
	private Personaje heroe1; 
	private Personaje heroe2;
	private Personaje heroe3;
	
    private Personaje villano1;
    private Personaje villano2;
    private Personaje villano3;
    
    private Juego juego;
	
	
	private Camuflaje camuflaje;
	private Modernidad modernidad;
	private Resistencia resistencia;
	
	@BeforeEach
	public void setUp() {
		heroe1=new Personaje("ironman", "ironman", true, false);
		heroe2=new Personaje("hulk", "hulk", true, false);
		heroe3=new Personaje("thor", "thor", true, false);		
		villano1=new Personaje("thanos", "thanos", false, true);
		villano2=new Personaje("venom", "venom", false, true);
		villano3=new Personaje("ultron", "ultron", false, true);
		
		juego=new Juego();
		
		//Las caracteristicas extras
		camuflaje=new Camuflaje();
		modernidad=new Modernidad();
		resistencia=new Resistencia();	
		
		
		heroe1.cargarCaracteristicas("Edad", 43);
		heroe1.cargarCaracteristicas("Fuerza", 500);
		heroe1.cargarCaracteristicas("Velocidad", 500);
		heroe1.cargarCaracteristicas("Tecnologia", 100);
		heroe1.cargarCaracteristicas("Invisibilidad", 20);
		heroe1.cargarCaracteristicas("Superpoderes", 500);				
		heroe1.cargarListaCaractExtras(camuflaje);
		heroe1.cargarListaCaractExtras(modernidad);
		heroe1.cargarListaCaractExtras(resistencia);		
		heroe1.calcularCaractExtras();
		
		heroe2.cargarCaracteristicas("Edad", 40);
		heroe2.cargarCaracteristicas("Fuerza", 300);
		heroe2.cargarCaracteristicas("Velocidad", 100);
		heroe2.cargarCaracteristicas("Tecnologia", 100);
		heroe2.cargarCaracteristicas("Invisibilidad", 20);
		heroe2.cargarCaracteristicas("Superpoderes", 300);				
		heroe2.cargarListaCaractExtras(camuflaje);
		heroe2.cargarListaCaractExtras(modernidad);
		heroe2.cargarListaCaractExtras(resistencia);		
		heroe2.calcularCaractExtras();
		
		heroe3.cargarCaracteristicas("Edad", 35);
		heroe3.cargarCaracteristicas("Fuerza", 500);
		heroe3.cargarCaracteristicas("Velocidad", 500);
		heroe3.cargarCaracteristicas("Tecnologia", 300);
		heroe3.cargarCaracteristicas("Invisibilidad", 80);
		heroe3.cargarCaracteristicas("Superpoderes", 500);				
		heroe3.cargarListaCaractExtras(camuflaje);
		heroe3.cargarListaCaractExtras(modernidad);
		heroe3.cargarListaCaractExtras(resistencia);		
		heroe3.calcularCaractExtras();
		
		villano1.cargarCaracteristicas("Edad", 45);
		villano1.cargarCaracteristicas("Fuerza", 200);
		villano1.cargarCaracteristicas("Velocidad", 100);
		villano1.cargarCaracteristicas("Tecnologia", 500);
		villano1.cargarCaracteristicas("Invisibilidad", 80);
		villano1.cargarCaracteristicas("Superpoderes", 700);				
		villano1.cargarListaCaractExtras(camuflaje);
		villano1.cargarListaCaractExtras(modernidad);
		villano1.cargarListaCaractExtras(resistencia);		
		villano1.calcularCaractExtras();
		
		
		
		juego.cargarPersonaje(heroe1);
		juego.cargarPersonaje(heroe2);
		juego.cargarPersonaje(heroe3);
		juego.cargarPersonaje(villano1);
		
		
		/*
		 * Cargar los criterios
		 */
		/*juego.cargarCriterios("Fuerza");
		juego.cargarCriterios("Tecnologia");
		juego.cargarCriterios("Camuflaje");
		juego.cargarCriterios("Resistencia");*/
		
	}	
	@Test
	public void testJugadaDarComoResultadoElPersonajeQueGanoPorTenerMayorValorEnUnSoloCriterio() {
		villano2.cargarCaracteristicas("Edad", 40);
		villano2.cargarCaracteristicas("Fuerza", 800);
		villano2.cargarCaracteristicas("Velocidad", 200);
		villano2.cargarCaracteristicas("Tecnologia", 500);
		villano2.cargarCaracteristicas("Invisibilidad", 80);
		villano2.cargarCaracteristicas("Superpoderes", 700);				
		villano2.cargarListaCaractExtras(camuflaje);
		villano2.cargarListaCaractExtras(modernidad);
		villano2.cargarListaCaractExtras(resistencia);		
		villano2.calcularCaractExtras();
		
		
		villano3.cargarCaracteristicas("Edad", 45);
		villano3.cargarCaracteristicas("Fuerza", 800);
		villano3.cargarCaracteristicas("Velocidad", 100);
		villano3.cargarCaracteristicas("Tecnologia", 500);
		villano3.cargarCaracteristicas("Invisibilidad", 80);
		villano3.cargarCaracteristicas("Superpoderes", 700);				
		villano3.cargarListaCaractExtras(camuflaje);
		villano3.cargarListaCaractExtras(modernidad);
		villano3.cargarListaCaractExtras(resistencia);		
		villano3.calcularCaractExtras();
		
		juego.cargarPersonaje(villano2);
		juego.cargarPersonaje(villano3);
		
		
		juego.cargarCriterios("Fuerza");
		juego.cargarCriterios("Velocidad");		
		juego.generarResultado();
		
		
	}
	
	@Test
	public void testPedimosQueSeAgrupePorHeroeyPorVillanoYNosDePorCriterioLaLigaGanadora() {
		
		villano2.cargarCaracteristicas("Edad", 40);
		villano2.cargarCaracteristicas("Fuerza", 800);
		villano2.cargarCaracteristicas("Velocidad", 200);
		villano2.cargarCaracteristicas("Tecnologia", 500);
		villano2.cargarCaracteristicas("Invisibilidad", 80);
		villano2.cargarCaracteristicas("Superpoderes", 700);				
		villano2.cargarListaCaractExtras(camuflaje);
		villano2.cargarListaCaractExtras(modernidad);
		villano2.cargarListaCaractExtras(resistencia);		
		villano2.calcularCaractExtras();
		
		
		villano3.cargarCaracteristicas("Edad", 45);
		villano3.cargarCaracteristicas("Fuerza", 800);
		villano3.cargarCaracteristicas("Velocidad", 100);
		villano3.cargarCaracteristicas("Tecnologia", 500);
		villano3.cargarCaracteristicas("Invisibilidad", 80);
		villano3.cargarCaracteristicas("Superpoderes", 700);				
		villano3.cargarListaCaractExtras(camuflaje);
		villano3.cargarListaCaractExtras(modernidad);
		villano3.cargarListaCaractExtras(resistencia);		
		villano3.calcularCaractExtras();
		
		juego.cargarPersonaje(villano2);
		juego.cargarPersonaje(villano3);
		
		
		juego.cargarCriterios("Fuerza");
		juego.cargarCriterios("Velocidad");	
		
		juego.formarLigaHeroes();
		juego.generarResultado();
		
	}
	
	@Test
	public void testSeEnfrentaUnaLigaAUnPersonajeDandoComoResultadoElQuePoseeMayorValor() {
		
		System.out.println("************************************");
		juego.cargarCriterios("Superpoderes");
		juego.cargarCriterios("Velocidad");	
		
		juego.formarLigaHeroes();
		juego.generarResultado();
		
	}

}
