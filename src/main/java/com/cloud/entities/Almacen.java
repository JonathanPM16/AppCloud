package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Almacen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idalmacen;
	
	@Size(min=3,max=45)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="idciudad")
	private Ciudad ciudad;
	
	@Size(min=3,max=15)
	private String tipoalmacen;

	public Almacen() {
		super();
	}

	public int getIdalmacen() {
		return idalmacen;
	}

	public void setIdalmacen(int idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getTipoalmacen() {
		return tipoalmacen;
	}

	public void setTipoalmacen(String tipoalmacen) {
		this.tipoalmacen = tipoalmacen;
	}
}
