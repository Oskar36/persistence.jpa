package com.txurdi.persistencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity                       // @Entity define que la entidad es persistible contra la base de datos
@Table(name = "libros")


@NamedQuery(query = "SELECT l FROM Libro l WHERE l.id = :id", name = "find libro by id")

public class Libro  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true)
	@NotNull
	@Size(min = 2 , max = 255 , message = "La longitud es muy larga")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_editorial")
	@Valid //sirve para validar en cascada cuando se valida este objeto
	private Editorial editorial;
	
	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.editorial = new Editorial();
	}
	public Libro(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	public Libro(String nombre,Editorial editorial) {
		this();
		this.nombre = nombre;
		this.editorial= editorial;
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

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + "]";
	}
	

}
