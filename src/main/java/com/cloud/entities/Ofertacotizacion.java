package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
public class Ofertacotizacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idofertacotizacion;
	
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="idsolicitudcotizacion")
	private Solicitudcotizacion solicitudcotizacion;
	
	@Digits(integer=8,fraction=2)
	private double costoxunidad;
	
	@Size(min=2,max=10)
	private String estado;

	public Ofertacotizacion() {
		super();
	}

	public int getIdofertacotizacion() {
		return idofertacotizacion;
	}

	public void setIdofertacotizacion(int idofertacotizacion) {
		this.idofertacotizacion = idofertacotizacion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Solicitudcotizacion getSolicitudcotizacion() {
		return solicitudcotizacion;
	}

	public void setSolicitudcotizacion(Solicitudcotizacion solicitudcotizacion) {
		this.solicitudcotizacion = solicitudcotizacion;
	}

	public double getCostoxunidad() {
		return costoxunidad;
	}

	public void setCostoxunidad(double costoxunidad) {
		this.costoxunidad = costoxunidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
