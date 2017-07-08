package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Tipoempleado {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtipoempleado;
	
	@Size(min=3,max=45)
	private String nombre;

	public Tipoempleado() {
		super();
	}

	public int getIdtipoempleado() {
		return idtipoempleado;
	}

	public void setIdtipoempleado(int idtipoempleado) {
		this.idtipoempleado = idtipoempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
