package com.cloud.service;

import com.cloud.entities.Producto;

public interface ProductoService {
	
	Producto saveProducto(Producto p);
	Iterable<Producto> listAllProducto();
	void deleteProducto(int idproducto);
	Producto getByIdproducto(int idproducto);
}
