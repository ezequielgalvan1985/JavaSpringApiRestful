package com.elementary.spring.mvc.model;

import javax.persistence.*;

@Entity
@Table(name="Publicidades")

public class Publicidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private int id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Producto producto;
    private int cantidad;

    private double precio;

    private double porcentaje;


    public Publicidad(){}

    public Publicidad(int id, String titulo, String descripcion, Empresa empresa, Producto producto, int cantidad, double precio, double porcentaje) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
