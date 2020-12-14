package tp1.epidata.test;



import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp1.epidata.modelo.Camuflaje;

import tp1.epidata.modelo.Juego;
import tp1.epidata.modelo.Modernidad;
import tp1.epidata.modelo.Personaje;
import tp1.epidata.modelo.Resistencia;


public class CargarPersonaje {
	private Personaje heroe1; 
	private Personaje heroe2;
	private Personaje heroe3;
	private Personaje heroe4;
    private Personaje villano1;
	
	private Juego juego;
	
	
	private Camuflaje camuflaje;
	private Modernidad modernidad;
	private Resistencia resistencia;

	@BeforeEach
	public void setUp() {
		heroe1=new Personaje("jugador1", "superman", true, false);
		heroe2=new Personaje("jugador1", "spiderman", true, false);
		heroe3=new Personaje("jugador1", "batman", true, false);
		heroe4=new Personaje("jugador1", "wonder woman", true, false);
		villano1=new Personaje("jugador2", "thanos", false, true);
		
		juego=new Juego();
		
		//Las caracteristicas extras
		camuflaje=new Camuflaje();
		modernidad=new Modernidad();
		resistencia=new Resistencia();		
		
	}	
	
	@Test
	public void testVerificamosQueLaCantidadDePersonajesSeaLasQueCargamos(){
		
		juego.cargarPersonaje(heroe1);
		juego.cargarPersonaje(heroe2);
		juego.cargarPersonaje(heroe3);
		juego.cargarPersonaje(heroe4);
		juego.cargarPersonaje(villano1);
		
		assertEquals(juego.cantidadPersonaje(),5);
		
	}
		
	@Test
	public void testValidarElCalculoDeLasCaracteristicasExtras(){
		//juego.cargarPersonaje(heroe1);
		
		//cargamos las caracteristicas
		
		heroe1.cargarCaracteristicas("Edad", 33);
		heroe1.cargarCaracteristicas("Fuerza", 700);
		heroe1.cargarCaracteristicas("Velocidad", 500);
		heroe1.cargarCaracteristicas("Tecnologia", 100);
		heroe1.cargarCaracteristicas("Invisibilidad", 80);
		heroe1.cargarCaracteristicas("Superpoderes", 200);
				
		
		heroe1.cargarListaCaractExtras(camuflaje);
		heroe1.cargarListaCaractExtras(modernidad);
		heroe1.cargarListaCaractExtras(resistencia);
		
		heroe1.calcularCaractExtras();
		
		assertEquals(heroe1.getValorCaracteristica("Resistencia"), (int)700/500);
		assertEquals(heroe1.getValorCaracteristica("Camuflaje"), 500);
		assertEquals(heroe1.getValorCaracteristica("Modernidad"), 10);
		
		
		
	}
	@Test
	public void testCapturamosExcepcionesYMostramosErroresQueNoExisteCaracteristicas() {
		
		
		heroe1.cargarCaracteristicas("Edad", 33);
		heroe1.cargarCaracteristicas("Fuerza", 700);
		heroe1.cargarCaracteristicas("Velocidad", 500);
		heroe1.cargarCaracteristicas("Invisibilidad", 80);
		
		heroe1.cargarListaCaractExtras(camuflaje);
		heroe1.cargarListaCaractExtras(modernidad);
		heroe1.cargarListaCaractExtras(resistencia);
		
		heroe1.calcularCaractExtras(); //Nos muestra error en Modernidad
		
		
		assertEquals(heroe1.getValorCaracteristica("Resistencia"), (int)700/500);
		assertEquals(heroe1.getValorCaracteristica("Camuflaje"), 500);
		//error no existe la caracteristica modernidad
		assertEquals(heroe1.getValorCaracteristica("Modernidad"), -1);
		
	}
	
	
	
	

}
