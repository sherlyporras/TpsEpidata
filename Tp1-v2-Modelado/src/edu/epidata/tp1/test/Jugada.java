package edu.epidata.tp1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.epidata.tp1.Juego;
import edu.epidata.tp1.atributo.AtributoSimple;
import edu.epidata.tp1.comparator.ComparatorCompuesto;
import edu.epidata.tp1.comparator.ComparatorCriterioSimple;
import edu.epidata.tp1.enfrentable.Enfrentable;
import edu.epidata.tp1.enfrentable.Liga;
import edu.epidata.tp1.enfrentable.Personaje;

public class Jugada {
	
	
	
	private Personaje personaje1;
	private Personaje personaje2;
	private Personaje personaje3;
	private Personaje personaje4;
	private Personaje personaje5;
	
	private Juego juego;
	private Liga liga1;
	
	private ComparatorCompuesto listaComparadores;
	
	@BeforeEach
	public void setUp() {
		
		personaje1=new Personaje("Person1", "superman");
		personaje1.addAtributo("Edad", new AtributoSimple(33));
		personaje1.addAtributo("Fuerza", new AtributoSimple(800));
		personaje1.addAtributo("Velocidad", new AtributoSimple(400));
		personaje1.addAtributo("Tecnologia", new AtributoSimple(100));
		personaje1.addAtributo("Invisibilidad", new AtributoSimple(80));
		personaje1.addAtributo("Superpoderes",  new AtributoSimple(200));
		
		
		personaje2=new Personaje("Person2", "thanos");
		personaje2.addAtributo("Tecnologia", new AtributoSimple(100));
		personaje2.addAtributo("Invisibilidad", new AtributoSimple(80));
		personaje2.addAtributo("Superpoderes",  new AtributoSimple(200));
		
		personaje3=new Personaje("Person3", "batman");
		personaje3.addAtributo("Edad", new AtributoSimple(43));
		personaje3.addAtributo("Fuerza", new AtributoSimple(500));
		personaje3.addAtributo("Velocidad", new AtributoSimple(800));
		personaje3.addAtributo("Tecnologia", new AtributoSimple(500));
		personaje3.addAtributo("Invisibilidad", new AtributoSimple(100));
		personaje3.addAtributo("Superpoderes",  new AtributoSimple(300));
		
		
		personaje4=new Personaje("Person4", "spiderman");
		personaje4.addAtributo("Edad", new AtributoSimple(40));
		personaje4.addAtributo("Fuerza", new AtributoSimple(200));
		personaje4.addAtributo("Velocidad", new AtributoSimple(800));
		
		
		personaje5=new Personaje("Person5", "ultron");
		personaje5.addAtributo("Invisibilidad", new AtributoSimple(200));
		personaje5.addAtributo("Superpoderes",  new AtributoSimple(500));
		
		
		juego=new Juego();
		juego.addEnfrentable(personaje1);
		juego.addEnfrentable(personaje2);
		juego.addEnfrentable(personaje3);
		juego.addEnfrentable(personaje4);
		juego.addEnfrentable(personaje5);
		
		liga1=new Liga("Suertudos", "suertudos");
		liga1.addIntegrante(personaje1);
		liga1.addIntegrante(personaje3);
		juego.addEnfrentable(liga1);		
		
		
		listaComparadores=new ComparatorCompuesto();
		
		
		
		
	}
	@Test 
	public void testEnfrentarPersonaje3vsPersonaje1ConCriterioSimpleFuerzaGanaSuperMan() {
		Comparator<Enfrentable> comparadorFuerza =new ComparatorCriterioSimple("Fuerza");
		Enfrentable personajeVencedor=personaje3.enfrentar(personaje1, comparadorFuerza);
		assertEquals(personajeVencedor.getNombreFantasia(),"superman");
	}
	
	@Test
	public void testEnfrentanLiga1vsPersonaje4ConCriterioSimpleVelocidadGanaSpiderman() {
		Comparator<Enfrentable> comparadorVelocidad =new ComparatorCriterioSimple("Velocidad");
		Enfrentable personajeVencedor=liga1.enfrentar(personaje4, comparadorVelocidad);
		assertEquals(personajeVencedor.getNombreFantasia(),"spiderman");
	}
	
	@Test
	public void testEnfrentarPersonaje1vsPersonaje3ConCriteriosCompuestosdeFuerzaYVelocidadGanaPersonaje3() {
		Comparator<Enfrentable> comparadorFuerza =new ComparatorCriterioSimple("Fuerza");
		Comparator<Enfrentable> comparadorVelocidad =new ComparatorCriterioSimple("Velocidad");
		listaComparadores.addComparators(comparadorVelocidad);
		listaComparadores.addComparators(comparadorFuerza);
		
		assertEquals(juego.enfrentar(personaje1, personaje3, listaComparadores).getNombreFantasia(),"batman");
		
		
		
		
		
		
		
		
	}

}
