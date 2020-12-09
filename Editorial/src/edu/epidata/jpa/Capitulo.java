package edu.epidata.jpa;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;



@Entity
public class Capitulo {
	@Id //Indica que es el identificador de las personas
	//@GeneratedValue(strategy = GenerationType.AUTO)//y que se crea automaticamente
	private int id;
	
	@Column
	private String titulo;
	@Column
	private int paginas;
	
	//Un capítulo tiene un solo revisor
	//Un revisor puede corregir muchos capítulos
	@ManyToOne	
	private Persona revisor;
	
	//Un capítulo puede tener muchos autores
	//Un autor puede haber escrito muchos capítulos
	@ManyToMany
	private List<Persona> autores =new ArrayList<Persona>();
	
	//Un libro tiene muchos capítulos
	//pero un capitulo está en un solo libro
	@ManyToOne
	private Libro libro;
	
	
	public Capitulo() {
		
	}
	public Capitulo(int id,String titulo, int paginas,Persona revisor,List<Persona> autores, Libro libro) {
		
		this.id=id;
		this.titulo=titulo;
		this.paginas=paginas;
		this.revisor=revisor;
		this.autores.addAll(autores);
		this.libro=libro;
	}
	
	
	
	
}