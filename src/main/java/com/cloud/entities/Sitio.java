package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Sitio {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idsitio;
	
	@Size(min=2,max=20)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idalmacen")
	private Almacen almacen;
	
	public Sitio() {
		super();
	}

	public int getIdsitio() {
		return idsitio;
	}

	public void setIdsitio(int idsitio) {
		this.idsitio = idsitio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
}
