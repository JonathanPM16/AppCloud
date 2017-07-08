package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Solicitudcotizacion {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idsolicitudcotizacion;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
	
	@Min(1)
	@Max(99)
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="idsitio")
	private Sitio sitio;
	
	@Size(min=2,max=10)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private Proveedor proveedor;
	
	@Digits(integer=8,fraction=2)
	private double costoxunidad;

	public Solicitudcotizacion() {
		super();
	}

	public int getIdsolicitudcotizacion() {
		return idsolicitudcotizacion;
	}

	public void setIdsolicitudcotizacion(int idsolicitudcotizacion) {
		this.idsolicitudcotizacion = idsolicitudcotizacion;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Sitio getSitio() {
		return sitio;
	}

	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public double getCostoxunidad() {
		return costoxunidad;
	}

	public void setCostoxunidad(double costoxunidad) {
		this.costoxunidad = costoxunidad;
	}
}
