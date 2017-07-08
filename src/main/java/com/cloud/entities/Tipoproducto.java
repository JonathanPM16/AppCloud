package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Tipoproducto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtipoproducto;
	
	@Size(min=3,max=45)
	private String nombre;

	public Tipoproducto() {
		super();
	}

	public int getIdtipoproducto() {
		return idtipoproducto;
	}

	public void setIdtipoproducto(int idtipoproducto) {
		this.idtipoproducto = idtipoproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
