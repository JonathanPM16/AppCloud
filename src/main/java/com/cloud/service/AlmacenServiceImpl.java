package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Almacen;
import com.cloud.repository.AlmacenRepository;

@Service
public class AlmacenServiceImpl implements AlmacenService {

	@Autowired
	private AlmacenRepository almacenRepository;
	
	@Override
	public Almacen saveAlmacen(Almacen a) {
		return almacenRepository.save(a);
	}

	@Override
	public Iterable<Almacen> listAllAlmacen() {
		return almacenRepository.findAll();
	}

	@Override
	public void deleteAlmacen(int idalmacen) {
		almacenRepository.delete(idalmacen);
	}

	@Override
	public Almacen getByIdalmacen(int idalmacen) {
		return almacenRepository.findOne(idalmacen);
	}

}
