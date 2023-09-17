package com.elementary.spring.mvc.model;

import org.hibernate.annotations.CreationTimestamp;
import com.elementary.spring.mvc.core.enums.EstadoConstantes;
import java.util.*;

import javax.persistence.*;



@Entity
@Table(name="pedidos")
public class Pedido {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
    private int id;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date fechacreated;
	
	private Date fechaupdated;
	
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Empresa empresa;
	private double descuento;
	
	private double impuestos;
	
	private double subtotal;

	private String estado = String.valueOf(EstadoConstantes.PENDIENTE);


	private boolean isPagado;

	public boolean isPagado() {
		return isPagado;
	}

	public void setPagado(boolean pagado) {
		isPagado = pagado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<PedidoItem> getItems() {
		return items;
	}


	@OneToMany( mappedBy = "pedido",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<PedidoItem> items = new HashSet<>();

	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechacreated() {
		return fechacreated;
	}

	public void setFechacreated(Date fechacreated) {
		this.fechacreated = fechacreated;
	}

	public Date getFechaupdated() {
		return fechaupdated;
	}

	public void setFechaupdated(Date fechaupdated) {
		this.fechaupdated = fechaupdated;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Pedido(int id, Date fechacreated, Date fechaupdated,
				  Usuario usuario, double descuento, double impuestos,
				  Empresa empresa, double subtotal, double total,
				  boolean pagado) {
		super();
		this.id = id;
		this.fechacreated = fechacreated;
		this.fechaupdated = fechaupdated;
		this.usuario = usuario;
		this.descuento = descuento;
		this.impuestos = impuestos;
		this.subtotal = subtotal;
		this.empresa = empresa;
		this.total = total;
		this.isPagado = pagado;
	}

	public Pedido() {
		super();
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
