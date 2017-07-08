package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Proveedor;
import com.cloud.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public Proveedor saveProveedor(Proveedor p) {
		return proveedorRepository.save(p);
	}

	@Override
	public Iterable<Proveedor> listAllProveedor() {
		return proveedorRepository.findAll();
	}

	@Override
	public void deleteProveedor(int idproveedor) {
		proveedorRepository.delete(idproveedor);
	}

	@Override
	public Proveedor getByIdproveedor(int idproveedor) {
		return proveedorRepository.findOne(idproveedor);
	}

}
