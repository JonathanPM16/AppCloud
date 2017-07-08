package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Transferenciaproducto;
import com.cloud.repository.TransferenciaproductoRepository;

@Service
public class TransferenciaproductoServiceImpl implements TransferenciaproductoService {

	@Autowired
	private TransferenciaproductoRepository transferenciaproductoRepository;
	
	@Override
	public Transferenciaproducto saveTransferenciaproducto(Transferenciaproducto tp) {
		return transferenciaproductoRepository.save(tp);
	}

	@Override
	public Iterable<Transferenciaproducto> listAllTransferenciaproducto() {
		return transferenciaproductoRepository.findAll();
	}

	@Override
	public void deleteTransferenciaproducto(int idtransferenciaproducto) {
		transferenciaproductoRepository.delete(idtransferenciaproducto);
	}

	@Override
	public Transferenciaproducto getByIdtransferenciaproducto(int idtransferenciaproducto) {
		return transferenciaproductoRepository.findOne(idtransferenciaproducto);
	}

}
