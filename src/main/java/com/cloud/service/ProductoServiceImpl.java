package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Producto;
import com.cloud.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto saveProducto(Producto p) {
		return productoRepository.save(p);
	}

	@Override
	public Iterable<Producto> listAllProducto() {
		return productoRepository.findAll();
	}

	@Override
	public void deleteProducto(int idproducto) {
		productoRepository.delete(idproducto);
	}

	@Override
	public Producto getByIdproducto(int idproducto) {
		return productoRepository.findOne(idproducto);
	}

}
