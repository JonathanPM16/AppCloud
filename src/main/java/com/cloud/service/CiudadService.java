package com.cloud.service;

import com.cloud.entities.Ciudad;

public interface CiudadService {

	Ciudad saveCiudad(Ciudad c);
	Iterable<Ciudad> listAllCiudad();
	void deleteCiudad(int idciudad);
	Ciudad getByIdciudad(int idciudad);
}