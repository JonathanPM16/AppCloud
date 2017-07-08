package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Transferenciaproducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	idtransferenciaproducto;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="idsitiodesde")
	private Sitio sitiodesde;
	
	@ManyToOne
	@JoinColumn(name="idsitiohasta")
	private Sitio sitiohasta;
	
	@Min(1)
	@Max(99)
	private int cantidad;
	
	@Size(min=2,max=10)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idempleadodos")
	private Empleado empleadodos;

	public Transferenciaproducto() {
		super();
	}

	public int getIdtransferenciaproducto() {
		return idtransferenciaproducto;
	}

	public void setIdtransferenciaproducto(int idtransferenciaproducto) {
		this.idtransferenciaproducto = idtransferenciaproducto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Sitio getSitiodesde() {
		return sitiodesde;
	}

	public void setSitiodesde(Sitio sitiodesde) {
		this.sitiodesde = sitiodesde;
	}

	public Sitio getSitiohasta() {
		return sitiohasta;
	}

	public void setSitiohasta(Sitio sitiohasta) {
		this.sitiohasta = sitiohasta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Empleado getEmpleadodos() {
		return empleadodos;
	}

	public void setEmpleadodos(Empleado empleadodos) {
		this.empleadodos = empleadodos;
	}
}
