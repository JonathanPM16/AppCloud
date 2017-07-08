package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Entradaproducto;
import com.cloud.repository.EntradaproductoRepository;

@Service
public class EntradaproductoServiceImpl implements EntradaproductoService {

	@Autowired
	private EntradaproductoRepository entradaproductoRepository;
	
	@Override
	public Entradaproducto saveEntradaproducto(Entradaproducto ep) {
		return entradaproductoRepository.save(ep);
	}

	@Override
	public Iterable<Entradaproducto> listAllEntradaproducto() {
		return entradaproductoRepository.findAll();
	}

	@Override
	public void deleteEntradaproducto(int identradaproducto) {
		entradaproductoRepository.delete(identradaproducto);
	}

	@Override
	public Entradaproducto getByIdentradaproducto(int identradaproducto) {
		return entradaproductoRepository.findOne(identradaproducto);
	}

}
