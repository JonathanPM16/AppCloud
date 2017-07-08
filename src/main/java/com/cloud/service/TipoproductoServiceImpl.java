package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Tipoproducto;
import com.cloud.repository.TipoproductoRepository;

@Service
public class TipoproductoServiceImpl implements TipoproductoService {

	@Autowired
	private TipoproductoRepository tipoproductoRepository;
	
	@Override
	public Tipoproducto saveTipoproducto(Tipoproducto tp) {
		return tipoproductoRepository.save(tp);
	}

	@Override
	public Iterable<Tipoproducto> listAllTipoproducto() {
		return tipoproductoRepository.findAll();
	}

	@Override
	public void deleteTipoproducto(int idtipoproducto) {
		tipoproductoRepository.delete(idtipoproducto);
	}

	@Override
	public Tipoproducto getByIdtipoproducto(int idtipoproducto) {
		return tipoproductoRepository.findOne(idtipoproducto);
	}

}
