package com.elementary.spring.mvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="UsuarioDatosPersonales")

public class UsuarioDatosPersonales {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    @Size(min = 3, message = "Debe tener al menos 3 caracteres")
    @Size(max = 50, message = "MAXIMO 50 CARACTERES")
    @NotNull
    private String nombre;

    @Size(max = 50, message = "MAXIMO 50 CARACTERES")
    private String apellido;

    @Column(name = "direccion", nullable = true, length = 250)
    private String direccion;


    private String telefono;

    private String ciudad;




    public UsuarioDatosPersonales(){}
    public UsuarioDatosPersonales(int id, String nombre, String apellido, String direccion, String ciudad, String telefono) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;

        this.telefono =telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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


}
