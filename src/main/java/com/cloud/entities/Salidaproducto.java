package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Salidaproducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	idsalidaproducto;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="idsitio")
	private Sitio sitio;
	
	@Min(1)
	@Max(99)
	private int cantidad;

	public Salidaproducto() {
		super();
	}

	public int getIdsalidaproducto() {
		return idsalidaproducto;
	}

	public void setIdsalidaproducto(int idsalidaproducto) {
		this.idsalidaproducto = idsalidaproducto;
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

	public Sitio getSitio() {
		return sitio;
	}

	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
