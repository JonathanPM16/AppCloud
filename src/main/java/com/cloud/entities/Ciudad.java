package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Ciudad {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idciudad;
	
	@Size(min=3,max=45)
	private String nombre;

	public Ciudad() {
		super();
	}

	public int getIdciudad() {
		return idciudad;
	}

	public void setIdciudad(int idciudad) {
		this.idciudad = idciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
