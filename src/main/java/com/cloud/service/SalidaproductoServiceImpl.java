package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Salidaproducto;
import com.cloud.repository.SalidaproductoRepository;

@Service
public class SalidaproductoServiceImpl implements SalidaproductoService {

	@Autowired
	private SalidaproductoRepository salidaproductoRepository;
	
	@Override
	public Salidaproducto saveSalidaproducto(Salidaproducto sp) {
		return salidaproductoRepository.save(sp);
	}

	@Override
	public Iterable<Salidaproducto> listAllSalidaproducto() {
		return salidaproductoRepository.findAll();
	}

	@Override
	public void deleteSalidaproducto(int salidaproducto) {
		salidaproductoRepository.delete(salidaproducto);
	}

	@Override
	public Salidaproducto getByIdsalidaproducto(int idsalidaproducto) {
		return salidaproductoRepository.findOne(idsalidaproducto);
	}

}
