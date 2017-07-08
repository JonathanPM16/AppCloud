package com.cloud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Proveedor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	idproveedor;
	
	@Size(min=2,max=45)
	private String nombre;
	
	@Size(min=2,max=45)
	private String apellido;
	
	@Size(min=2,max=10)
	private String usuario;

	@Size(min=4,max=20)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;

	public Proveedor() {
		super();
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
