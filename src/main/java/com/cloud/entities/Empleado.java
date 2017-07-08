package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Empleado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	idempleado;
	
	@Size(min=2,max=45)
	private String nombre;
	
	@Size(min=2,max=45)
	private String apellido;
	
	@Size(min=2,max=10)
	private String usuario;

	@Size(min=4,max=200)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="idtipoempleado")
	private Tipoempleado tipoempleado;

	public Empleado() {
		super();
	}

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Tipoempleado getTipoempleado() {
		return tipoempleado;
	}

	public void setTipoempleado(Tipoempleado tipoempleado) {
		this.tipoempleado = tipoempleado;
	}
}
