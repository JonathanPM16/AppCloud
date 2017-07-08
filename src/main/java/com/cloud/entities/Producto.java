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
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idproducto;
	
	@Size(min=3,max=45)
	private String nombre;
	
	@Size(min=1,max=10)
	private String medida;
	
	@ManyToOne
	@JoinColumn(name="idtipoproducto")
	private Tipoproducto tipoproducto;
	
	@Digits(integer=8,fraction=2)
	private double precio;
	
	public Producto() {
		super();
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public Tipoproducto getTipoproducto() {
		return tipoproducto;
	}

	public void setTipoproducto(Tipoproducto tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
