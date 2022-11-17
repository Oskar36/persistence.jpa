package com.txurdi.persistencia.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="editorial")
public class Editorial  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
		
	private String nombre;
	
	@OneToMany(mappedBy = "editorial")
	private Set<Libro> libros;
	
	public Editorial() {
		super();
		this.id = 0;
		this.nombre = "";
		this.libros= new HashSet<Libro>();
	}
	public Editorial(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	public Editorial(String nombre, Set<Libro> libros) {
		this();
		this.nombre = nombre;
		this.libros= libros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + "]";
	}
	

}
