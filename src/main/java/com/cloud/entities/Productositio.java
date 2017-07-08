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
public class Productositio {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idproducto_sitio;
	
	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="idsitio")
	private Sitio sitio;
	
	@Min(1)
	@Max(100)
	private int cantidad;
	
	public Productositio() {
		super();
	}

	public int getIdproducto_sitio() {
		return idproducto_sitio;
	}

	public void setIdproducto_sitio(int idproducto_sitio) {
		this.idproducto_sitio = idproducto_sitio;
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
