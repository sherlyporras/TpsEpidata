package edu.epidata.tp1.enfrentable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.epidata.tp1.atributo.Atributo;

public class Personaje extends Enfrentable{
	
	private Map<String, Atributo> atributos;
	
	
	public Personaje(String nombre, String nombreFantasia) {
		// TODO Auto-generated constructor stub
		this.atributos=new HashMap<String, Atributo>();
		this.nombre=nombre;
		this.nombreFantasia=nombreFantasia;
	}
	
	public int getCantidadAtributos() {
		return atributos.size();
	}
	
	public Atributo getAtributo(String nombreAtributo) {
		return atributos.get(nombreAtributo);
	}

	@Override
	public float getValorAtributo(String nomAtributo) {
		try {
			return this.atributos.get(nomAtributo).getValor(this);
		}catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	protected List<Personaje> getPersonajes() {
		List<Personaje> auxpersonaje=new LinkedList<Personaje>();
		auxpersonaje.add(this);
		
		return auxpersonaje;
	}
	
	public Boolean addAtributo(String name, Atributo a) {
		try {
			atributos.put(name, a);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
