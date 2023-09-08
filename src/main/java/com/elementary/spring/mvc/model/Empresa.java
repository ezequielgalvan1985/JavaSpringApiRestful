package com.elementary.spring.mvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Empresas")
public class Empresa {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre", nullable = false, length = 100)
	@Size(min = 3, message = "Debe tener al menos 3 caracteres")
	@NotNull
	private String nombre;

	@Column(name = "rubro", nullable = true, length = 50)
	@Size(max = 50, message = "Debe tener maximo 4 caracteres")
	private String rubro;

	@Column(name = "frase", nullable = true, length = 200)
	@Size(max = 200, message = "Debe tener maximo 4 caracteres")
	private String frase;

	@Column(name = "descripcion", nullable = true, length = 200)
	@Size(max = 200, message = "Debe tener maximo 4 caracteres")
	private String descripcion;

	@Column(name = "direccion", nullable = true, length = 200)
	@Size(max = 200, message = "Debe tener maximo 4 caracteres")
	private String direccion;

	@Column(name = "ciudad", nullable = true, length = 50)
	@Size(max = 50, message = "Debe tener maximo 4 caracteres")
	private String ciudad;
	@Column(name = "telefono", nullable = true, length = 30)
	@Size(max = 30, message = "Debe tener maximo 30 caracteres")
	private String telefono;

	@OneToOne(optional = true)
	private Usuario usuario;

	public Empresa(){}
	public Empresa(int id, String nombre, String rubro, String frase, String descripcion, String direccion, String ciudad, String telefono, Usuario usuario) {
		this.id = id;
		this.nombre = nombre;
		this.rubro = rubro;
		this.frase = frase;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.usuario = usuario;
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

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
