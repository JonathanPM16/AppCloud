package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Ciudad;
import com.cloud.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public Ciudad saveCiudad(Ciudad c) {
		return ciudadRepository.save(c);
	}

	@Override
	public Iterable<Ciudad> listAllCiudad() {
		return ciudadRepository.findAll();
	}

	@Override
	public void deleteCiudad(int idciudad) {
		ciudadRepository.delete(idciudad);
	}

	@Override
	public Ciudad getByIdciudad(int idciudad) {
		return ciudadRepository.findOne(idciudad);
	}

}
