package edu.epidata.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Libro {
	@Id //indica que es el identificador
	//@GeneratedValue(strategy = GenerationType.AUTO)//Y que se crea automáticamente
	private int id;
	
	@Column
	private String nombre;
	@Column
	private int anio;
	@ManyToMany
	private List<Persona> editores =new ArrayList<Persona>();
	
	//Un libro tiene muchos capítulos
	//pero un capitulo está en un solo libro
	//El mapeo es realizado por Capitulo (mappedBy)
	@OneToMany(mappedBy = "libro")
	private List<Capitulo> capitulos=new ArrayList<Capitulo>();
	
	public Libro() {
		
	}
	public Libro(int id, String nombre, int anio, List<Persona> editores) {
		
		this.id=id;
		this.nombre=nombre;
		this.anio=anio;
		this.editores.addAll(editores);
		
	}
}