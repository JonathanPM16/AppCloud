package com.cloud.service;

import com.cloud.entities.Almacen;

public interface AlmacenService {
	
	Almacen saveAlmacen(Almacen a);
	Iterable<Almacen> listAllAlmacen();
	void deleteAlmacen(int idalmacen);
	Almacen getByIdalmacen(int idalmacen);
}
