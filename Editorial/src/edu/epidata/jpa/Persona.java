package edu.epidata.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;

@Entity //Indica que se persiste en la BD
public class Persona {
	@Id //Indica que es el identificador de las personas
	//@GeneratedValue(strategy=GenerationType.AUTO) //Y que se crea automáticamente
	
	private int id;
	
	@Column //Indica que es una columna en la BDs
	private String nombre;
	@Column
	private String apellido;
	@Column(nullable=false) //Indica que no puede ser null
	private String mail;
	
	public Persona() {
		
	}
	public Persona(String nom, String ape, String mail) {
		this.nombre=nom;
		this.apellido=ape;
		this.mail=mail;
	}
	public Persona(int id,String nom, String ape, String mail) {
		
		this.id=id;
		this.nombre=nom;
		this.apellido=ape;
		this.mail=mail;
	}
	
	public int getId() {
		return this.id;
		
	}
	public String getNombre() {
		return this.nombre;
		
	}
	public String getApellido() {
		return this.apellido;
		
	}

}