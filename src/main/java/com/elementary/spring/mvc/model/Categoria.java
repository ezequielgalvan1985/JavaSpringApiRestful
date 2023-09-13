package com.elementary.spring.mvc.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="Categorias")
public class Categoria  {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
    private int id;
	
	@Column(name="nombre")
	@Size(min=3, message="Debe tener al menos 3 caracteres")
	@NotNull
	private String nombre;
	
	@Column(name="descripcion")
	@Size(min=10, message="Debe tener al menos 10 caracteres")
	@NotNull
	private String descripcion;


	@ManyToOne
	private Rubro rubro;

	public Categoria(int id, String nombre, String descripcion, Rubro rubro) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rubro = rubro;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public Categoria() {
		super();
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
