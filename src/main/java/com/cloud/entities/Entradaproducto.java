package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Entradaproducto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identradaproducto;
	
	@ManyToOne
	@JoinColumn(name="idsolicitudcotizacion")
	private Solicitudcotizacion solicitudcotizacion;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;
	
	@Size(min=2,max=10)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idempleadodos")
	private Empleado empleadodos;

	public Entradaproducto() {
		super();
	}

	public int getIdentradaproducto() {
		return identradaproducto;
	}

	public void setIdentradaproducto(int identradaproducto) {
		this.identradaproducto = identradaproducto;
	}

	public Solicitudcotizacion getSolicitudcotizacion() {
		return solicitudcotizacion;
	}

	public void setSolicitudcotizacion(Solicitudcotizacion solicitudcotizacion) {
		this.solicitudcotizacion = solicitudcotizacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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
