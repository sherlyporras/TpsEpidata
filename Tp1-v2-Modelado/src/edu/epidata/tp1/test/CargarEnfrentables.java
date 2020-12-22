package edu.epidata.tp1.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import edu.epidata.tp1.atributo.AtributoCondicional;
import edu.epidata.tp1.atributo.AtributoSimple;
import edu.epidata.tp1.atributo.OperacionDivisionAtributos;
import edu.epidata.tp1.enfrentable.Liga;
import edu.epidata.tp1.enfrentable.Personaje;



public class CargarEnfrentables {
	
	private Personaje personaje1;
	private Personaje personaje2;
	private Personaje personaje3;
	private Personaje personaje4;
	private Personaje personaje5;
	
	
	
	
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
		
		
		
	}
	
	@Test
	public void testVerificamosQueLosAtributosCalculadosSeCargaronAdecuadamente() {
		personaje1.addAtributo("Resistencia", new OperacionDivisionAtributos("Fuerza", "Velocidad"));
		
		personaje1.addAtributo("Camuflaje", new AtributoCondicional("Invisibilidad", "Fuerza", new AtributoSimple(50),personaje1.getAtributo("Velocidad")));
		assertEquals(2,personaje1.getValorAtributo("Resistencia"));
		//el valor de camuflaje sera el de la velocidad.
		assertEquals(personaje1.getValorAtributo("Camuflaje"), personaje1.getValorAtributo("Velocidad"));
		
	}
	@Test
	public void testVerificamosQueSiPedimosValorDeLosAtributosQueNoExistenArrojaCero() {
		
		assertEquals(personaje5.getValorAtributo("Edad"), 0.0);
		assertEquals(personaje5.getValorAtributo("PoderAgua"), 0.0);

	}
	
	
	
	
	

}
