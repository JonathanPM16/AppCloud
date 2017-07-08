package com.cloud.service;

import com.cloud.entities.Proveedor;

public interface ProveedorService {

	Proveedor saveProveedor(Proveedor p);
	Iterable<Proveedor> listAllProveedor();
	void deleteProveedor(int idproveedor);
	Proveedor getByIdproveedor(int idproveedor);
}
